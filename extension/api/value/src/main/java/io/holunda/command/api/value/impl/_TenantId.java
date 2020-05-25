package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.impl.ValueWrapper.NonEmptyStringValueWrapper;
import io.holunda.command.lib.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _TenantId extends NonEmptyStringValueWrapper implements TenantId {
  // empty generator template
}
