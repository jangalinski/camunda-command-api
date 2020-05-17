package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.impl.ValueImplGenerator.StringValueWrapper;
import io.holunda.command.api.value.impl.ValueImplGenerator.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _ProcessDefinitionKey extends StringValueWrapper implements ProcessDefinitionKey {
  // empty generator template
}
