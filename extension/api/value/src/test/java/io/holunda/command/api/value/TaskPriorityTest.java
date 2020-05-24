package io.holunda.command.api.value;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.holunda.command.api.value.TaskPriority.TaskPriorityLabel;
import org.junit.Test;

public class TaskPriorityTest {


  @Test
  public void taskPriorityLabel_by_value() {
    assertThat(TaskPriorityLabel.byPriority(0)).isEqualTo(TaskPriorityLabel.LOWEST);
    assertThat(TaskPriorityLabel.byPriority(19)).isEqualTo(TaskPriorityLabel.LOWEST);

    assertThat(TaskPriorityLabel.byPriority(20)).isEqualTo(TaskPriorityLabel.LOW);
    assertThat(TaskPriorityLabel.byPriority(39)).isEqualTo(TaskPriorityLabel.LOW);

    assertThat(TaskPriorityLabel.byPriority(40)).isEqualTo(TaskPriorityLabel.NORMAL);
    assertThat(TaskPriorityLabel.byPriority(59)).isEqualTo(TaskPriorityLabel.NORMAL);

    assertThat(TaskPriorityLabel.byPriority(60)).isEqualTo(TaskPriorityLabel.HIGH);
    assertThat(TaskPriorityLabel.byPriority(79)).isEqualTo(TaskPriorityLabel.HIGH);

    assertThat(TaskPriorityLabel.byPriority(80)).isEqualTo(TaskPriorityLabel.HIGHEST);
    assertThat(TaskPriorityLabel.byPriority(100)).isEqualTo(TaskPriorityLabel.HIGHEST);

    assertThatThrownBy(() -> TaskPriorityLabel.byPriority(-1)).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> TaskPriorityLabel.byPriority(101)).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void getTaskPriorityLabel() {
    assertThat(of(0).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.LOWEST);
    assertThat(of(19).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.LOWEST);

    assertThat(of(20).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.LOW);
    assertThat(of(39).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.LOW);

    assertThat(of(40).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.NORMAL);
    assertThat(of(59).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.NORMAL);

    assertThat(of(60).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.HIGH);
    assertThat(of(79).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.HIGH);

    assertThat(of(80).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.HIGHEST);
    assertThat(of(100).getTaskPriorityLabel()).isEqualTo(TaskPriorityLabel.HIGHEST);

    assertThatThrownBy(() -> of(-1).getTaskPriorityLabel()).isInstanceOf(IllegalArgumentException.class);
    assertThatThrownBy(() -> of(101).getTaskPriorityLabel()).isInstanceOf(IllegalArgumentException.class);
  }


  private static TaskPriority of(int value) {
    return new TaskPriority() {
      @Override
      public int getValue() {
        return value;
      }
    };
  }
}
