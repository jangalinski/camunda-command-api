package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.TaskPriority;
import io.holunda.command.api.value.impl.ValueImplGenerator.IntValueWrapper;
import org.immutables.value.Value;

abstract class _TaskPriority extends IntValueWrapper implements TaskPriority {

  @Override
  @Value.Derived
  public TaskPriorityLabel getTaskPriorityLabel() {
    return TaskPriorityLabel.byPriority(getValue());
  }
}
