package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.impl.ProcessInstanceIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessInstanceIdMapper {

  String FROM = "ProcessInstanceIdToString";
  String TO = "StringToProcessInstanceId";

  ProcessInstanceIdMapper INSTANCE = Mappers.getMapper(ProcessInstanceIdMapper.class);

  @Named(ProcessInstanceIdMapper.TO)
  default ProcessInstanceId convert(String value) {
    return ProcessInstanceIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ProcessInstanceId> convertOptional(String value) {
    return Optional.ofNullable(value).map(ProcessInstanceIdValue::of);
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convert(final ProcessInstanceId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ProcessInstanceId> value) {
    return value.map(ProcessInstanceId::getValue).orElse(null);
  }
}
