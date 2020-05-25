package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.processDefinitionId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProcessDefinitionIdTest {

  @Test
  public void create() {
    assertThat(processDefinitionId("12").getValue()).isEqualTo("12");
  }
}
