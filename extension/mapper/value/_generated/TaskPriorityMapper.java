package io.holunda.command.mapper.value;

import io.holunda.command.api.value.TaskPriority;
import io.holunda.command.api.value.impl.TaskPriorityValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskPriorityMapper {

  String FROM = "TaskPriorityToInteger";
  String TO = "IntegerToTaskPriority";

  TaskPriorityMapper INSTANCE = Mappers.getMapper(TaskPriorityMapper.class);

  @Named(TaskPriorityMapper.TO)
  default TaskPriority convert(Integer value) {
    return TaskPriorityValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<TaskPriority> convertOptional(Integer value) {
    return Optional.ofNullable(value).map(TaskPriorityValue::of);
  }

  @Named(TaskPriorityMapper.FROM)
  default Integer convert(final TaskPriority value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default Integer convertOptional(final Optional<TaskPriority> value) {
    return value.map(TaskPriority::getValue).orElse(null);
  }
}
