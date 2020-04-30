package io.holunda.command.api;

import io.holunda.command.api.CamundaCommandApi.CamundaCommand;
import io.holunda.command.api.model.BusinessKey;
import io.holunda.command.api.model.CaseInstanceId;
import io.holunda.command.api.model.Immutables.ImmutableObject;
import io.holunda.command.api.model.ProcessDefinitionKey;
import java.util.Optional;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.immutables.value.Value.Default;

@Value.Immutable
@ImmutableObject
interface _StartProcessByKeyCommand extends CamundaCommand {

  ProcessDefinitionKey getProcessDefinitionKey();

  Optional<BusinessKey> getBusinessKey();

  @Value.Default
  default VariableMap getVariables() {
    return Variables.createVariables();
  }

  Optional<CaseInstanceId> getCaseInstanceId();

  @Value.Default
  default boolean isReturnWithVariables() {
    return false;
  }
}
