package io.holunda.command.mapper.value;

import io.holunda.command.api.value.MessageName;
import io.holunda.command.api.value.impl.MessageNameValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MessageNameMapper {

  String FROM = "MessageNameToString";
  String TO = "StringToMessageName";

  MessageNameMapper INSTANCE = Mappers.getMapper(MessageNameMapper.class);

  @Named(MessageNameMapper.TO)
  default MessageName convert(String value) {
    return MessageNameValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<MessageName> convertOptional(String value) {
    return Optional.ofNullable(value).map(MessageNameValue::of);
  }

  @Named(MessageNameMapper.FROM)
  default String convert(final MessageName value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<MessageName> value) {
    return value.map(MessageName::getValue).orElse(null);
  }
}
