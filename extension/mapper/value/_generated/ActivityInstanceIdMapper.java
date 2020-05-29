package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ActivityInstanceId;
import io.holunda.command.api.value.impl.ActivityInstanceIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityInstanceIdMapper {

  String FROM = "ActivityInstanceIdToString";
  String TO = "StringToActivityInstanceId";

  ActivityInstanceIdMapper INSTANCE = Mappers.getMapper(ActivityInstanceIdMapper.class);

  @Named(ActivityInstanceIdMapper.TO)
  default ActivityInstanceId convert(String value) {
    return ActivityInstanceIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ActivityInstanceId> convertOptional(String value) {
    return Optional.ofNullable(value).map(ActivityInstanceIdValue::of);
  }

  @Named(ActivityInstanceIdMapper.FROM)
  default String convert(final ActivityInstanceId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ActivityInstanceId> value) {
    return value.map(ActivityInstanceId::getValue).orElse(null);
  }
}
