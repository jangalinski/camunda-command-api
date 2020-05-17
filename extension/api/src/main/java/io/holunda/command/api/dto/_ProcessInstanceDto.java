package io.holunda.command.api.dto;

import io.holunda.command.api.CamundaCommandApi.Immutables.ImmutableObject;
import io.holunda.command.api.mapper.ProcessInstanceMapper;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.TenantId;
import java.util.Optional;
import java.util.function.Supplier;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.immutables.value.Value.Default;
import org.jetbrains.annotations.Nullable;

@Value.Immutable
@ImmutableObject
interface _ProcessInstanceDto extends Supplier<ProcessInstance> {

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
  default ProcessInstanceWithVariables get() {
    return ProcessInstanceMapper.processInstance(ProcessInstanceDto.copyOf(this));
  }
}
