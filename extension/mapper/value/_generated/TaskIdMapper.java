package io.holunda.command.mapper.value;

import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.impl.TaskIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskIdMapper {

  String FROM = "TaskIdToString";
  String TO = "StringToTaskId";

  TaskIdMapper INSTANCE = Mappers.getMapper(TaskIdMapper.class);

  @Named(TaskIdMapper.TO)
  default TaskId convert(String value) {
    return TaskIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<TaskId> convertOptional(String value) {
    return Optional.ofNullable(value).map(TaskIdValue::of);
  }

  @Named(TaskIdMapper.FROM)
  default String convert(final TaskId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<TaskId> value) {
    return value.map(TaskId::getValue).orElse(null);
  }
}
