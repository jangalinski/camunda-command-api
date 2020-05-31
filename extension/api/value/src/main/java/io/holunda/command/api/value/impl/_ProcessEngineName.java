package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.ProcessEngineName;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _ProcessEngineName extends NonEmptyStringValueWrapper implements ProcessEngineName {
  // empty generator template
}
