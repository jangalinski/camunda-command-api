package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.impl.ProcessInstanceIdValue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProcessInstanceIdMapper {

  ProcessInstanceIdMapper INSTANCE = Mappers.getMapper(ProcessInstanceIdMapper.class);

  default ProcessInstanceId toValue(String string) {
    return ProcessInstanceIdValue.of(string);
  }

  default String fromValue(ProcessInstanceId value) {
    return value.getValue();
  }

}
