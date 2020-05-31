package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.TaskPriority;
import io.holunda.command.api.value.TaskPriorityLabel;
import io.holunda.command.api.value.impl.ValueWrapper.IntValueWrapper;
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _TaskPriority extends IntValueWrapper implements TaskPriority {

  @Override
  @Value.Derived
  public TaskPriorityLabel getTaskPriorityLabel() {
    return TaskPriorityLabel.byPriority(getValue());
  }

  @Value.Check
  void check() {
    getTaskPriorityLabel();
  }
}
