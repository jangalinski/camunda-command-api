package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ProcessEngineName;
import io.holunda.command.api.value.impl.ProcessEngineNameValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessEngineNameMapper {

  String FROM = "ProcessEngineNameToString";
  String TO = "StringToProcessEngineName";

  ProcessEngineNameMapper INSTANCE = Mappers.getMapper(ProcessEngineNameMapper.class);

  @Named(ProcessEngineNameMapper.TO)
  default ProcessEngineName convert(String value) {
    return ProcessEngineNameValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ProcessEngineName> convertOptional(String value) {
    return Optional.ofNullable(value).map(ProcessEngineNameValue::of);
  }

  @Named(ProcessEngineNameMapper.FROM)
  default String convert(final ProcessEngineName value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ProcessEngineName> value) {
    return value.map(ProcessEngineName::getValue).orElse(null);
  }
}
