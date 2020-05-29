package io.holunda.command.mapper.value;

import io.holunda.command.api.value.FormKey;
import io.holunda.command.api.value.impl.FormKeyValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FormKeyMapper {

  String FROM = "FormKeyToString";
  String TO = "StringToFormKey";

  FormKeyMapper INSTANCE = Mappers.getMapper(FormKeyMapper.class);

  @Named(FormKeyMapper.TO)
  default FormKey convert(String value) {
    return FormKeyValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<FormKey> convertOptional(String value) {
    return Optional.ofNullable(value).map(FormKeyValue::of);
  }

  @Named(FormKeyMapper.FROM)
  default String convert(final FormKey value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<FormKey> value) {
    return value.map(FormKey::getValue).orElse(null);
  }
}
