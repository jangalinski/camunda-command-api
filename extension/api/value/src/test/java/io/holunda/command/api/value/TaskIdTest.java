package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.taskId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TaskIdTest {

  @Test
  public void create() {
    assertThat(taskId("12").getValue()).isEqualTo("12");
  }
}
