package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ExecutionId;
import io.holunda.command.api.value.impl.ExecutionIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ExecutionIdMapper {

  String FROM = "ExecutionIdToString";
  String TO = "StringToExecutionId";

  ExecutionIdMapper INSTANCE = Mappers.getMapper(ExecutionIdMapper.class);

  @Named(ExecutionIdMapper.TO)
  default ExecutionId convert(String value) {
    return ExecutionIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ExecutionId> convertOptional(String value) {
    return Optional.ofNullable(value).map(ExecutionIdValue::of);
  }

  @Named(ExecutionIdMapper.FROM)
  default String convert(final ExecutionId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ExecutionId> value) {
    return value.map(ExecutionId::getValue).orElse(null);
  }
}
