package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.taskPriority;
import static io.holunda.command.api.value.TaskPriorityLabel.HIGH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class TaskPriorityTest {

  @Test
  public void create_from_enum() {
    assertThat(taskPriority(HIGH).getValue()).isEqualTo(75);
    assertThat(taskPriority(HIGH).getTaskPriorityLabel()).isEqualTo(HIGH);
  }

  @Test
  public void check_fails() {
    assertThatThrownBy(() -> taskPriority(-1)).isInstanceOf(IllegalArgumentException.class);
  }

}
