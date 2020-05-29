package io.holunda.command.mapper.value;

import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.impl.TenantIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TenantIdMapper {

  String FROM = "TenantIdToString";
  String TO = "StringToTenantId";

  TenantIdMapper INSTANCE = Mappers.getMapper(TenantIdMapper.class);

  @Named(TenantIdMapper.TO)
  default TenantId convert(String value) {
    return TenantIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<TenantId> convertOptional(String value) {
    return Optional.ofNullable(value).map(TenantIdValue::of);
  }

  @Named(TenantIdMapper.FROM)
  default String convert(final TenantId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<TenantId> value) {
    return value.map(TenantId::getValue).orElse(null);
  }
}
