package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.VersionTag;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _VersionTag extends NonEmptyStringValueWrapper implements VersionTag {
  // empty generator template
}
