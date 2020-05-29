package io.holunda.command.mapper.value;

import io.holunda.command.api.value.TaskDefinitionKey;
import io.holunda.command.api.value.impl.TaskDefinitionKeyValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskDefinitionKeyMapper {

  String FROM = "TaskDefinitionKeyToString";
  String TO = "StringToTaskDefinitionKey";

  TaskDefinitionKeyMapper INSTANCE = Mappers.getMapper(TaskDefinitionKeyMapper.class);

  @Named(TaskDefinitionKeyMapper.TO)
  default TaskDefinitionKey convert(String value) {
    return TaskDefinitionKeyValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<TaskDefinitionKey> convertOptional(String value) {
    return Optional.ofNullable(value).map(TaskDefinitionKeyValue::of);
  }

  @Named(TaskDefinitionKeyMapper.FROM)
  default String convert(final TaskDefinitionKey value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<TaskDefinitionKey> value) {
    return value.map(TaskDefinitionKey::getValue).orElse(null);
  }
}
