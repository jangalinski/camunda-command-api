package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.api.value.impl.ProcessDefinitionKeyValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessDefinitionKeyMapper {

  String FROM = "ProcessDefinitionKeyToString";
  String TO = "StringToProcessDefinitionKey";

  ProcessDefinitionKeyMapper INSTANCE = Mappers.getMapper(ProcessDefinitionKeyMapper.class);

  @Named(ProcessDefinitionKeyMapper.TO)
  default ProcessDefinitionKey convert(String value) {
    return ProcessDefinitionKeyValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ProcessDefinitionKey> convertOptional(String value) {
    return Optional.ofNullable(value).map(ProcessDefinitionKeyValue::of);
  }

  @Named(ProcessDefinitionKeyMapper.FROM)
  default String convert(final ProcessDefinitionKey value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ProcessDefinitionKey> value) {
    return value.map(ProcessDefinitionKey::getValue).orElse(null);
  }
}
