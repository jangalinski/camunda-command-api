package io.holunda.command.mapper.dto;

import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.mapper.value.ProcessInstanceIdMapper;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
  ProcessInstanceIdMapper.class
}, unmappedSourcePolicy = ReportingPolicy.WARN, unmappedTargetPolicy = ReportingPolicy.WARN
)
public interface ProcessInstanceDtoMapper {

  ProcessInstanceDtoMapper INSTANCE = Mappers.getMapper(ProcessInstanceDtoMapper.class);

  // ProcessInstanceWithVariables fromDto(ProcessInstanceDto dto);

  // ProcessInstanceDto convert(ProcessInstance object);
}
