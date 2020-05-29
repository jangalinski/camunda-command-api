package io.holunda.command.mapper.value;

import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.impl.CaseInstanceIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CaseInstanceIdMapper {

  String FROM = "CaseInstanceIdToString";
  String TO = "StringToCaseInstanceId";

  CaseInstanceIdMapper INSTANCE = Mappers.getMapper(CaseInstanceIdMapper.class);

  @Named(CaseInstanceIdMapper.TO)
  default CaseInstanceId convert(String value) {
    return CaseInstanceIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<CaseInstanceId> convertOptional(String value) {
    return Optional.ofNullable(value).map(CaseInstanceIdValue::of);
  }

  @Named(CaseInstanceIdMapper.FROM)
  default String convert(final CaseInstanceId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<CaseInstanceId> value) {
    return value.map(CaseInstanceId::getValue).orElse(null);
  }
}
