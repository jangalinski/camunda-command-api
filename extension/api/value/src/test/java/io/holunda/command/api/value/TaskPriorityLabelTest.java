package io.holunda.command.api.value;

import static io.holunda.command.api.value.TaskPriorityLabel.HIGH;
import static io.holunda.command.api.value.TaskPriorityLabel.HIGHEST;
import static io.holunda.command.api.value.TaskPriorityLabel.LOW;
import static io.holunda.command.api.value.TaskPriorityLabel.LOWEST;
import static io.holunda.command.api.value.TaskPriorityLabel.NORMAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class TaskPriorityLabelTest {
  @Test
  public void taskPriorityLabel_by_value() {
    assertThat(TaskPriorityLabel.byPriority(0)).isEqualTo(LOWEST);
    assertThat(TaskPriorityLabel.byPriority(19)).isEqualTo(LOWEST);

    assertThat(TaskPriorityLabel.byPriority(20)).isEqualTo(LOW);
    assertThat(TaskPriorityLabel.byPriority(39)).isEqualTo(LOW);

    assertThat(TaskPriorityLabel.byPriority(40)).isEqualTo(NORMAL);
    assertThat(TaskPriorityLabel.byPriority(59)).isEqualTo(NORMAL);

    assertThat(TaskPriorityLabel.byPriority(60)).isEqualTo(HIGH);
    assertThat(TaskPriorityLabel.byPriority(79)).isEqualTo(HIGH);

    assertThat(TaskPriorityLabel.byPriority(80)).isEqualTo(HIGHEST);
    assertThat(TaskPriorityLabel.byPriority(100)).isEqualTo(HIGHEST);

    assertThatThrownBy(() -> TaskPriorityLabel.byPriority(-1)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> TaskPriorityLabel.byPriority(101)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void getTaskPriorityLabel() {
    assertThat(of(0).getTaskPriorityLabel()).isEqualTo(LOWEST);
    assertThat(of(19).getTaskPriorityLabel()).isEqualTo(LOWEST);

    assertThat(of(20).getTaskPriorityLabel()).isEqualTo(LOW);
    assertThat(of(39).getTaskPriorityLabel()).isEqualTo(LOW);

    assertThat(of(40).getTaskPriorityLabel()).isEqualTo(NORMAL);
    assertThat(of(59).getTaskPriorityLabel()).isEqualTo(NORMAL);

    assertThat(of(60).getTaskPriorityLabel()).isEqualTo(HIGH);
    assertThat(of(79).getTaskPriorityLabel()).isEqualTo(HIGH);

    assertThat(of(80).getTaskPriorityLabel()).isEqualTo(HIGHEST);
    assertThat(of(100).getTaskPriorityLabel()).isEqualTo(HIGHEST);

    assertThatThrownBy(() -> of(-1).getTaskPriorityLabel()).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> of(101).getTaskPriorityLabel()).isInstanceOf(IllegalArgumentException.class);
  }

  private static TaskPriority of(int value) {
    return () -> value;
  }
}
