package io.holunda.command.mapper.value;

import io.holunda.command.api.value.GroupId;
import io.holunda.command.api.value.impl.GroupIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GroupIdMapper {

  String FROM = "GroupIdToString";
  String TO = "StringToGroupId";

  GroupIdMapper INSTANCE = Mappers.getMapper(GroupIdMapper.class);

  @Named(GroupIdMapper.TO)
  default GroupId convert(String value) {
    return GroupIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<GroupId> convertOptional(String value) {
    return Optional.ofNullable(value).map(GroupIdValue::of);
  }

  @Named(GroupIdMapper.FROM)
  default String convert(final GroupId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<GroupId> value) {
    return value.map(GroupId::getValue).orElse(null);
  }
}
