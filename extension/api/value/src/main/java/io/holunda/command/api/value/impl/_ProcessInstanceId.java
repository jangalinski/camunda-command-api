package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.lib.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _ProcessInstanceId extends NonEmptyStringValueWrapper implements ProcessInstanceId {
  // empty generator template
}
