package io.holunda.command.api.model;

import io.holunda.command.api.model.Immutables.StringWrapper;
import io.holunda.command.api.model.Immutables.Wrapped;
import java.util.UUID;
import org.immutables.value.Value;

@Value.Immutable
@Wrapped
abstract class _BusinessKey extends StringWrapper {

  public static BusinessKey random() {
    return BusinessKey.of(UUID.randomUUID().toString());
  }
}
