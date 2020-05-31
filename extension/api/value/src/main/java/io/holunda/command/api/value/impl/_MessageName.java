package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.MessageName;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _MessageName extends NonEmptyStringValueWrapper implements MessageName {
  // empty generator template
}
