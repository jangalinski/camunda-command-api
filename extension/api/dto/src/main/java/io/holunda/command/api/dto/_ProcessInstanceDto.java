package io.holunda.command.api.dto;

import io.holunda.command.api.dto.CamundaDtos.CamundaDto;
import io.holunda.command.api.dto.CamundaDtos.Immutables.ImmutableCamundaDto;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaValues;
import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.ProcessEngineName;
import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.TenantId;
import java.util.Optional;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.immutables.value.Value.Default;

@Value.Immutable
@ImmutableCamundaDto
interface _ProcessInstanceDto extends CamundaDto {

  ProcessInstanceId getId();

  @Default
  default ProcessInstanceId getProcessInstanceId() {
    return getId();
  }

  ProcessDefinitionId getProcessDefinitionId();

  Optional<BusinessKey> getBusinessKey();

  ProcessInstanceId getRootProcessInstanceId();

  Optional<CaseInstanceId> getCaseInstanceId();

  @Default
  default boolean isSuspended() {
    return false;
  }

  @Default
  default boolean isEnded() {
    return false;
  }

  Optional<TenantId> getTenantId();

  @Value.Default
  default VariableMap getVariables() {
    return Variables.createVariables();
  }

  @Override
  default ProcessEngineName getProcessEngineName() {
    return CamundaValues.DEFAULT_PROCESS_ENGINE_NAME;
  }

}
