package io.holunda.command.api.dto;

import io.holunda.command.api.camunda.ImmutableProcessInstance;
import io.holunda.command.api.mapper.ProcessInstanceMapper;
import io.holunda.command.api.model.BusinessKey;
import io.holunda.command.api.model.CaseInstanceId;
import io.holunda.command.api.model.Immutables.ImmutableObject;
import io.holunda.command.api.model.ProcessDefinitionId;
import io.holunda.command.api.model.ProcessInstanceId;
import io.holunda.command.api.model.TenantId;
import java.util.Optional;
import java.util.function.Supplier;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

@Value.Immutable
@ImmutableObject
interface _ProcessInstanceDto extends Supplier<ProcessInstance> {

  ProcessInstanceId getId();

  ProcessDefinitionId getProcessDefinitionId();

  @Nullable
  BusinessKey getBusinessKey();

  ProcessInstanceId getRootProcessInstanceId();

  @Nullable
  CaseInstanceId getCaseInstanceId();

  boolean isSuspended();

  boolean isEnded();

  ProcessInstanceId getProcessInstanceId();

  @Nullable
  TenantId getTenantId();

  @Value.Default
  default VariableMap getVariables() {
    return Variables.createVariables();
  }

  @Override
  default ProcessInstanceWithVariables get() {
    return ProcessInstanceMapper.processInstance(ProcessInstanceDto.copyOf(this));
  }


}
