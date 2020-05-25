package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.executionId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ExecutionIdTest {

  @Test
  public void create() {
    assertThat(executionId("12").getValue()).isEqualTo("12");
  }
}
