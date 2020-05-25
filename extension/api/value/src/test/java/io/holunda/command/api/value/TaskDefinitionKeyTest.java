package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.taskDefinitionKey;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TaskDefinitionKeyTest {

  @Test
  public void create() {
    assertThat(taskDefinitionKey("task").getValue()).isEqualTo("task");
  }
}
