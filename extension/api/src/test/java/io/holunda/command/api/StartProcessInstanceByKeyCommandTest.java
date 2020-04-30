package io.holunda.command.api;

import io.holunda.command.api.model.BusinessKey;
import org.immutables.value.Value;

@Value.Immutable
public interface StartProcessInstanceByKeyCommandTest {

  BusinessKey getBusinessKey();

}
