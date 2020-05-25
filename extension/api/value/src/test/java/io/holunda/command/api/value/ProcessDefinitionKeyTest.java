package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.processDefinitionKey;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProcessDefinitionKeyTest {

  @Test
  public void create() {
    assertThat(processDefinitionKey("process").getValue()).isEqualTo("process");
  }
}
