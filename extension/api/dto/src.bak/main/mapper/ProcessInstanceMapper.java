package io.holunda.command.api.mapper;

import static io.holunda.command.api.value.CamundaValue.processDefinitionId;
import static io.holunda.command.api.value.CamundaValue.processInstanceId;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.TenantId;
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
      .id(dto.getId().getValue())
      .processDefinitionId(dto.getProcessDefinitionId().getValue())
      .businessKey(dto.getBusinessKey().map(BusinessKey::getValue).orElse(null))
      .rootProcessInstanceId(dto.getRootProcessInstanceId().getValue())
      .caseInstanceId(dto.getCaseInstanceId().map(CaseInstanceId::getValue).orElse(null))
      .isSuspended(dto.isSuspended())
      .isEnded(dto.isEnded())
      .processInstanceId(dto.getProcessInstanceId().getValue())
      .tenantId(dto.getTenantId().map(TenantId::getValue).orElse(null))
      .variables(Optional.ofNullable(dto.getVariables()).orElse(Variables.createVariables()))
      .build();
  }

  private static ProcessInstanceDto.Builder processInstanceDtoBuilder(ProcessInstance processInstance) {
    return ProcessInstanceDto.builder()
      .id(processInstanceId(processInstance.getId()))
      .processDefinitionId(processDefinitionId(processInstance.getId()))
      .businessKey(Optional.ofNullable(processInstance.getBusinessKey()).map(CamundaCommandApi::businessKey))
      .rootProcessInstanceId(processInstanceId(processInstance.getId()))
      .caseInstanceId(Optional.ofNullable(processInstance.getCaseInstanceId()).map(CamundaCommandApi::caseInstanceId))
      .isSuspended(processInstance.isSuspended())
      .isEnded(processInstance.isEnded())
      .processInstanceId(processInstanceId(processInstance.getProcessInstanceId()))
      .tenantId(Optional.ofNullable(processInstance.getTenantId()).map(CamundaCommandApi::tenantId));
  }
}
