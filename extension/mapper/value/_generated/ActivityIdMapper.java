package io.holunda.command.mapper.value;

import io.holunda.command.api.value.ActivityId;
import io.holunda.command.api.value.impl.ActivityIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ActivityIdMapper {

  String FROM = "ActivityIdToString";
  String TO = "StringToActivityId";

  ActivityIdMapper INSTANCE = Mappers.getMapper(ActivityIdMapper.class);

  @Named(ActivityIdMapper.TO)
  default ActivityId convert(String value) {
    return ActivityIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<ActivityId> convertOptional(String value) {
    return Optional.ofNullable(value).map(ActivityIdValue::of);
  }

  @Named(ActivityIdMapper.FROM)
  default String convert(final ActivityId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<ActivityId> value) {
    return value.map(ActivityId::getValue).orElse(null);
  }
}
