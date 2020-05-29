package io.holunda.command.mapper.value;

import io.holunda.command.api.value.UserId;
import io.holunda.command.api.value.impl.UserIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserIdMapper {

  String FROM = "UserIdToString";
  String TO = "StringToUserId";

  UserIdMapper INSTANCE = Mappers.getMapper(UserIdMapper.class);

  @Named(UserIdMapper.TO)
  default UserId convert(String value) {
    return UserIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<UserId> convertOptional(String value) {
    return Optional.ofNullable(value).map(UserIdValue::of);
  }

  @Named(UserIdMapper.FROM)
  default String convert(final UserId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<UserId> value) {
    return value.map(UserId::getValue).orElse(null);
  }
}
