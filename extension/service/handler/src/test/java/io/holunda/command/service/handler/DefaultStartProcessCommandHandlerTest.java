package io.holunda.command.service.handler;

import static io.holunda.command.api.value.CamundaValues.businessKey;
import static io.holunda.command.api.value.CamundaValues.processDefinitionKey;
import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.api.command.StartProcessByKeyCommand;
import io.holunda.command.api.command.StartProcessCommand;
import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.api.value.impl.BusinessKeyValue;
import io.holunda.command.lib.test.TestProcessEngine;
import java.util.UUID;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.model.bpmn.Bpmn;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;

public class DefaultStartProcessCommandHandlerTest {

  private static final ProcessDefinitionKey KEY = processDefinitionKey("dummy");
  private static final BusinessKey BUSINESS_KEY = businessKey(UUID.randomUUID().toString());

  @Rule
  public final ProcessEngineRule camunda = TestProcessEngine.processEngineRule();

  private DefaultStartProcessCommandHandler handler;

  @Before
  public void setUp() throws Exception {
    camunda.manageDeployment(camunda.getRepositoryService().createDeployment()
      .addModelInstance("dummy.bpmn", Bpmn.createExecutableProcess(KEY.getValue())
        .startEvent()
        .userTask("task")
        .endEvent()
        .done())
      .deploy());

    handler = new DefaultStartProcessCommandHandler(camunda.getRuntimeService());
  }

  @Test
  @Ignore("return is still null")
  public void start_by_key_with_businessKey() {
    ProcessInstanceDto processInstanceDto = handler.startProcess(StartProcessCommand.byKey(KEY)
      .build());

    assertThat(processInstanceDto.getBusinessKey()).isEqualTo(BUSINESS_KEY);
  }
}
