package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.impl.ProcessDefinitionIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessDefinitionIdMapper {

  String FROM = "ProcessDefinitionIdToString";
  String TO = "StringToProcessDefinitionId";

  ProcessDefinitionIdMapper INSTANCE = Mappers.getMapper(ProcessDefinitionIdMapper.class);

  @Named(ProcessDefinitionIdMapper.TO)
  default ProcessDefinitionId convert(String value) {
    return ProcessDefinitionIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ProcessDefinitionId> convertOptional(String value) {
    return Optional.ofNullable(value).map(ProcessDefinitionIdValue::of);
  }

  @Named(ProcessDefinitionIdMapper.FROM)
  default String convert(final ProcessDefinitionId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ProcessDefinitionId> value) {
    return value.map(ProcessDefinitionId::getValue).orElse(null);
  }
}
