package io.holunda.command.jackson;

import static io.holunda.command.api.CamundaCommandApi.businessKey;
import static io.holunda.command.api.CamundaCommandApi.processDefinitionKey;
import static io.holunda.command.api.CamundaCommandApi.processInstanceId;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import io.holunda.command.api.StartProcessByKeyCommand;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.ProcessInstanceId;
import java.util.Objects;
import org.camunda.bpm.engine.variable.Variables;
import org.junit.Test;

public class CamundaCommandModuleTest {

  private final ObjectMapper om = new ObjectMapper()
    .registerModule(new Jdk8Module())
    .registerModule(new CamundaCommandModule());

  @Test
  public void convert_businessKey() throws JsonProcessingException {
    BusinessKey bk = businessKey("1");

    String json = om.writeValueAsString(bk);

    System.out.println("json: " + json);

    BusinessKey businessKey = om.readValue(json, BusinessKey.class);

    System.out.println(businessKey);
  }

  @Test
  public void convert_complex() throws JsonProcessingException {

    SomeComplexType ct = new SomeComplexType(businessKey("111"), processInstanceId("222"), 17L, "222");

    String json = om.writeValueAsString(ct);

    System.out.println(json);

    SomeComplexType cp = om.readValue(json, SomeComplexType.class);

    System.out.println(cp);

    assertThat(cp).isEqualTo(ct);
  }

  @Test
  public void json_start_command() throws JsonProcessingException {
    StartProcessByKeyCommand command = StartProcessByKeyCommand.builder()
      .processDefinitionKey(processDefinitionKey("the_process"))
      .businessKey(businessKey("the-key"))
      .variables(Variables.putValue("foo", "bar"))
      .isReturnWithVariables(true)
      .build();

    String json = om.writeValueAsString(command);

    assertThat(om.readValue(json, StartProcessByKeyCommand.class)).isEqualTo(command);
  }

  public static class SomeComplexType {

    private BusinessKey businessKey;
    private ProcessInstanceId processInstanceId;
    private long hello;
    private String other;

    public SomeComplexType() {
    }

    public SomeComplexType(BusinessKey businessKey,
      ProcessInstanceId processInstanceId, long hello, String other) {
      this.businessKey = businessKey;
      this.processInstanceId = processInstanceId;
      this.hello = hello;
      this.other = other;
    }

    public BusinessKey getBusinessKey() {
      return businessKey;
    }

    public void setBusinessKey(BusinessKey businessKey) {
      this.businessKey = businessKey;
    }

    public ProcessInstanceId getProcessInstanceId() {
      return processInstanceId;
    }

    public String getOther() {
      return other;
    }

    public void setOther(String other) {
      this.other = other;
    }

    public void setProcessInstanceId(ProcessInstanceId processInstanceId) {
      this.processInstanceId = processInstanceId;
    }

    public long getHello() {
      return hello;
    }

    public void setHello(long hello) {
      this.hello = hello;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      SomeComplexType that = (SomeComplexType) o;
      return hello == that.hello &&
        Objects.equals(businessKey, that.businessKey) &&
        Objects.equals(processInstanceId, that.processInstanceId) &&
        Objects.equals(other, that.other);
    }

    @Override
    public int hashCode() {
      return Objects.hash(businessKey, processInstanceId, hello, other);
    }

    @Override
    public String toString() {
      return "SomeComplexType{" +
        "businessKey=" + businessKey +
        ", processInstanceId=" + processInstanceId +
        ", hello=" + hello +
        ", other='" + other + '\'' +
        '}';
    }
  }
}
