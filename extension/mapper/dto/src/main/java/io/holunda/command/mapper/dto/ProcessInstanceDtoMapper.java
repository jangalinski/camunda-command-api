package io.holunda.command.mapper.dto;

import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.value.TenantId;
import io.holunda.command.mapper.value.BusinessKeyMapper;
import io.holunda.command.mapper.value.CamundaValueMappers.VariableMapMapper;
import io.holunda.command.mapper.value.CaseInstanceIdMapper;
import io.holunda.command.mapper.value.ProcessDefinitionIdMapper;
import io.holunda.command.mapper.value.ProcessInstanceIdMapper;
import io.holunda.command.mapper.value.TaskIdMapper;
import io.holunda.command.mapper.value.TenantIdMapper;
import io.holunda.commons.immutables.ImmutableProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
  BusinessKeyMapper.class,
  CaseInstanceIdMapper.class,
  ProcessInstanceIdMapper.class,
  ProcessDefinitionIdMapper.class,
  TenantIdMapper.class,
  VariableMapMapper.class
}, unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN
)
public interface ProcessInstanceDtoMapper {

  ProcessInstanceDtoMapper INSTANCE = Mappers.getMapper(ProcessInstanceDtoMapper.class);

  @Mapping(target = "id", qualifiedByName = ProcessInstanceIdMapper.FROM)
  @Mapping(target = "processInstanceId", qualifiedByName = ProcessInstanceIdMapper.FROM)
  @Mapping(target = "rootProcessInstanceId", qualifiedByName = ProcessInstanceIdMapper.FROM)
  @Mapping(target = "caseInstanceId", qualifiedByName = CaseInstanceIdMapper.FROM)
  @Mapping(target = "processDefinitionId", qualifiedByName = ProcessDefinitionIdMapper.FROM)
  @Mapping(target = "businessKey", qualifiedByName = BusinessKeyMapper.FROM)
  @Mapping(target = "tenantId", qualifiedByName = TenantIdMapper.FROM)
  ImmutableProcessInstance fromDto(ProcessInstanceDto dto);

  @Mapping(target = "id", qualifiedByName = ProcessInstanceIdMapper.TO)
  @Mapping(target = "processInstanceId", qualifiedByName = ProcessInstanceIdMapper.TO)
  @Mapping(target = "processDefinitionId", qualifiedByName = ProcessDefinitionIdMapper.TO)
  @Mapping(target = "businessKey", qualifiedByName = BusinessKeyMapper.TO)
  @Mapping(target = "rootProcessInstanceId", qualifiedByName = ProcessInstanceIdMapper.TO)
  @Mapping(target = "caseInstanceId", qualifiedByName = CaseInstanceIdMapper.TO)
  @Mapping(target = "tenantId", qualifiedByName = TenantIdMapper.TO)
  ProcessInstanceDto convert(ProcessInstance object);
}
