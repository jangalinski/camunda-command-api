package io.holunda.command.mapper.value;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.impl.BusinessKeyValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessKeyMapper {

  String FROM = "BusinessKeyToString";
  String TO = "StringToBusinessKey";

  BusinessKeyMapper INSTANCE = Mappers.getMapper(BusinessKeyMapper.class);

  @Named(BusinessKeyMapper.TO)
  default BusinessKey convert(String value) {
    return BusinessKeyValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<BusinessKey> convertOptional(String value) {
    return Optional.ofNullable(value).map(BusinessKeyValue::of);
  }

  @Named(BusinessKeyMapper.FROM)
  default String convert(final BusinessKey value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<BusinessKey> value) {
    return value.map(BusinessKey::getValue).orElse(null);
  }
}
