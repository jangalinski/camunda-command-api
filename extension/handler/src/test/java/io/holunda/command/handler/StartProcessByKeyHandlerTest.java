package io.holunda.command.handler;

import static io.holunda.command.api.CamundaCommandApi.businessKey;
import static io.holunda.command.api.CamundaCommandApi.processDefinitionKey;

import io.holunda.command.api.StartProcessByKeyCommand;
import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.handler.StartProcessByKeyHandlerTest.DummyProcess.VARIABLES;
import io.holunda.command.test.TestProcessEngine;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.assertj.core.api.Assertions;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.assertions.bpmn.BpmnAwareTests;
import org.camunda.bpm.engine.test.mock.Mocks;
import org.camunda.bpm.engine.variable.Variables;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.camunda.bpm.model.bpmn.BpmnModelInstance;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class StartProcessByKeyHandlerTest {

  private static final ProcessDefinitionKey KEY = processDefinitionKey("dummy");

  @Rule
  public final ProcessEngineRule camunda = TestProcessEngine.processEngineRule();

  private StartProcessByKeyHandler handler;

  @Before
  public void setUp() {
    this.handler = new StartProcessByKeyHandler(camunda.getRuntimeService());

    camunda.manageDeployment(
      camunda.getRepositoryService().createDeployment()
        .addModelInstance(DummyProcess.BPMN, DummyProcess.PROCESS)
        .deploy());

    Mocks.register(DummyProcess.DELEGATE, DummyProcess.CALCULATOR_DELEGATE);
  }

  @Test
  public void startByKey_only_business_key() {
    StartProcessByKeyCommand cmd = StartProcessByKeyCommand.builder()
      .processDefinitionKey(KEY)
      .build();

    ProcessInstanceDto dto = handler.handle(cmd);

    ProcessInstanceWithVariables processInstance = dto.get();

    BpmnAwareTests.assertThat(processInstance).isEnded();
    Assertions.assertThat(processInstance.getBusinessKey()).isNull();
    Assertions.assertThat(processInstance.getVariables()).isEmpty();
  }

  @Test
  public void startByKey_with_businessKey() {
    BusinessKey businessKey = businessKey(UUID.randomUUID().toString());
    StartProcessByKeyCommand cmd = StartProcessByKeyCommand.builder()
      .processDefinitionKey(KEY)
      .businessKey(businessKey)
      .build();

    ProcessInstanceDto dto = handler.handle(cmd);
    ProcessInstanceWithVariables processInstance = dto.get();

    BpmnAwareTests.assertThat(processInstance).isEnded();
    Assertions.assertThat(processInstance.getBusinessKey()).isEqualTo(businessKey.getValue());
    Assertions.assertThat(processInstance.getVariables()).isEmpty();
  }

  @Test
  public void startByKey_with_businessKey_and_variable() {
    BusinessKey businessKey = businessKey(UUID.randomUUID().toString());
    Integer num = 2;

    StartProcessByKeyCommand cmd = StartProcessByKeyCommand.builder()
      .processDefinitionKey(KEY)
      .businessKey(businessKey)
      .variables(Variables.putValue(VARIABLES.NUMBER, num))
      .isReturnWithVariables(true)
      .build();

    ProcessInstanceDto dto = handler.handle(cmd);
    ProcessInstanceWithVariables processInstance = dto.get();

    BpmnAwareTests.assertThat(processInstance).isEnded();
    Assertions.assertThat(processInstance.getBusinessKey()).isEqualTo(businessKey.getValue());
    Assertions.assertThat(processInstance.getVariables()).isNotEmpty();
    BpmnAwareTests.assertThat(processInstance).hasVariables(VARIABLES.RESULT);
    Assertions.assertThat(processInstance.getVariables().get(VARIABLES.RESULT)).isEqualTo(businessKey.getValue() + "/" + 4);
  }

  @Test
  public void startByKey_isReturnWithVariables_with_businessKey_and_variable() {
    BusinessKey businessKey = businessKey(UUID.randomUUID().toString());
    Integer num = 2;

    StartProcessByKeyCommand cmd = StartProcessByKeyCommand.builder()
      .processDefinitionKey(KEY)
      .businessKey(businessKey)
      .variables(Variables.putValue(VARIABLES.NUMBER, num))
      .build();

    ProcessInstanceDto dto = handler.handle(cmd);
    ProcessInstanceWithVariables processInstance = dto.get();

    BpmnAwareTests.assertThat(processInstance).isEnded();
    Assertions.assertThat(processInstance.getBusinessKey()).isEqualTo(businessKey.getValue());
    Assertions.assertThat(processInstance.getVariables()).isEmpty();
  }

  public static class DummyProcess {
    private static final ProcessDefinitionKey KEY = processDefinitionKey("dummy");
    private static final String BPMN = KEY.getValue() + ".bpmn";
    private static final String DELEGATE = "calculator";

    enum VARIABLES {
      ;

      private static final String RESULT = "result";
      private static final String NUMBER = "number";

    }

    public static BpmnModelInstance PROCESS = Bpmn.createExecutableProcess(KEY.getValue())
      .startEvent()
      .serviceTask("calculator")
      .camundaDelegateExpression("${calculator}")
      .endEvent()
      .done();

    public static final JavaDelegate CALCULATOR_DELEGATE =  execution -> {
      List<String> result = new ArrayList<>();

      Optional.ofNullable(execution.getBusinessKey()).ifPresent(result::add);

      int square = Optional.ofNullable(execution.getVariable(VARIABLES.NUMBER)).map(Integer.class::cast).orElse(0);

      result.add("" + square * square);

      execution.setVariable(VARIABLES.RESULT, String.join("/",result));
    };
  }
}
