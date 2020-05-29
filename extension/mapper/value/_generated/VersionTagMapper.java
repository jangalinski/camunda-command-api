package io.holunda.command.mapper.value;

import io.holunda.command.api.value.VersionTag;
import io.holunda.command.api.value.impl.VersionTagValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VersionTagMapper {

  String FROM = "VersionTagToString";
  String TO = "StringToVersionTag";

  VersionTagMapper INSTANCE = Mappers.getMapper(VersionTagMapper.class);

  @Named(VersionTagMapper.TO)
  default VersionTag convert(String value) {
    return VersionTagValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<VersionTag> convertOptional(String value) {
    return Optional.ofNullable(value).map(VersionTagValue::of);
  }

  @Named(VersionTagMapper.FROM)
  default String convert(final VersionTag value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<VersionTag> value) {
    return value.map(VersionTag::getValue).orElse(null);
  }
}
