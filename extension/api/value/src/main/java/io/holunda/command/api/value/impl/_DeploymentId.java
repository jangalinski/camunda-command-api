package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.DeploymentId;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.lib.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _DeploymentId extends NonEmptyStringValueWrapper implements DeploymentId {
  // empty generator template
}
