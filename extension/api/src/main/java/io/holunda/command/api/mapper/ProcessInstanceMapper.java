package io.holunda.command.api.mapper;

import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.model.BusinessKey;
import io.holunda.command.api.model.CaseInstanceId;
import io.holunda.command.api.model.ProcessDefinitionId;
import io.holunda.command.api.model.ProcessInstanceId;
import io.holunda.command.api.model.TenantId;
import io.holunda.commons.immutables.ImmutableProcessInstance;
import java.util.Optional;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.Variables;

public enum ProcessInstanceMapper {
  ;


  public static ProcessInstanceDto processInstanceDto(final ProcessInstance processInstance) {
    return processInstanceDtoBuilder(processInstance)
      .build();
  }

  public static ProcessInstanceDto processInstanceDto(final ProcessInstanceWithVariables processInstance) {
    return processInstanceDtoBuilder(processInstance)
      .variables(Optional.ofNullable(processInstance.getVariables()).orElse(Variables.createVariables()))
      .build();
  }

  public static ProcessInstanceWithVariables processInstance(final ProcessInstanceDto dto) {
    return ImmutableProcessInstance.builder()
      .id(dto.getId().value())
      .processDefinitionId(dto.getProcessDefinitionId().value())
      .businessKey(Optional.ofNullable(dto.getBusinessKey()).map(BusinessKey::value).orElse(null))
      .rootProcessInstanceId(dto.getRootProcessInstanceId().value())
      .caseInstanceId(Optional.ofNullable(dto.getCaseInstanceId()).map(CaseInstanceId::value).orElse(null))
      .isSuspended(dto.isSuspended())
      .isEnded(dto.isEnded())
      .processInstanceId(dto.getProcessInstanceId().value())
      .tenantId(Optional.ofNullable(dto.getTenantId()).map(TenantId::value).orElse(null))
      .variables(Optional.ofNullable(dto.getVariables()).orElse(Variables.createVariables()))
      .build();
  }

  private static ProcessInstanceDto.Builder processInstanceDtoBuilder(ProcessInstance processInstance) {
    return ProcessInstanceDto.builder()
      .id(ProcessInstanceId.of(processInstance.getId()))
      .processDefinitionId(ProcessDefinitionId.of(processInstance.getId()))
      .businessKey(Optional.ofNullable(processInstance.getBusinessKey()).map(BusinessKey::of).orElse(null))
      .rootProcessInstanceId(ProcessInstanceId.of(processInstance.getId()))
      .caseInstanceId(Optional.ofNullable(processInstance.getCaseInstanceId()).map(CaseInstanceId::of).orElse(null))
      .isSuspended(processInstance.isSuspended())
      .isEnded(processInstance.isEnded())
      .processInstanceId(ProcessInstanceId.of(processInstance.getProcessInstanceId()))
      .tenantId(Optional.ofNullable(processInstance.getTenantId()).map(TenantId::of).orElse(null));
  }
}
