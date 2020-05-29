package io.holunda.command.mapper.value;

import io.holunda.command.api.value.TopicName;
import io.holunda.command.api.value.impl.TopicNameValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicNameMapper {

  String FROM = "TopicNameToString";
  String TO = "StringToTopicName";

  TopicNameMapper INSTANCE = Mappers.getMapper(TopicNameMapper.class);

  @Named(TopicNameMapper.TO)
  default TopicName convert(String value) {
    return TopicNameValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<TopicName> convertOptional(String value) {
    return Optional.ofNullable(value).map(TopicNameValue::of);
  }

  @Named(TopicNameMapper.FROM)
  default String convert(final TopicName value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<TopicName> value) {
    return value.map(TopicName::getValue).orElse(null);
  }
}
