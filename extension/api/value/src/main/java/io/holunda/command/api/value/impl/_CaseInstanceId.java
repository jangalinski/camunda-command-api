package io.holunda.command.api.value.impl;

import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.impl.ValueImplGenerator.StringValueWrapper;
import io.holunda.command.api.value.impl.ValueImplGenerator.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _CaseInstanceId extends StringValueWrapper implements CaseInstanceId {

}
