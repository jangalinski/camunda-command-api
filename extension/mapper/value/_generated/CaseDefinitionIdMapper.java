package io.holunda.command.mapper.value;

import io.holunda.command.api.value.CaseDefinitionId;
import io.holunda.command.api.value.impl.CaseDefinitionIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CaseDefinitionIdMapper {

  String FROM = "CaseDefinitionIdToString";
  String TO = "StringToCaseDefinitionId";

  CaseDefinitionIdMapper INSTANCE = Mappers.getMapper(CaseDefinitionIdMapper.class);

  @Named(CaseDefinitionIdMapper.TO)
  default CaseDefinitionId convert(String value) {
    return CaseDefinitionIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<CaseDefinitionId> convertOptional(String value) {
    return Optional.ofNullable(value).map(CaseDefinitionIdValue::of);
  }

  @Named(CaseDefinitionIdMapper.FROM)
  default String convert(final CaseDefinitionId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<CaseDefinitionId> value) {
    return value.map(CaseDefinitionId::getValue).orElse(null);
  }
}
