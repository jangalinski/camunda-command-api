package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.ActivityInstanceId;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _ActivityInstanceId extends NonEmptyStringValueWrapper implements ActivityInstanceId {
  // empty generator template
}
