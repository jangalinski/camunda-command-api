package io.holunda.command.mapper.value;

import io.holunda.command.api.value.IncidentId;
import io.holunda.command.api.value.impl.IncidentIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IncidentIdMapper {

  String FROM = "IncidentIdToString";
  String TO = "StringToIncidentId";

  IncidentIdMapper INSTANCE = Mappers.getMapper(IncidentIdMapper.class);

  @Named(IncidentIdMapper.TO)
  default IncidentId convert(String value) {
    return IncidentIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<IncidentId> convertOptional(String value) {
    return Optional.ofNullable(value).map(IncidentIdValue::of);
  }

  @Named(IncidentIdMapper.FROM)
  default String convert(final IncidentId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<IncidentId> value) {
    return value.map(IncidentId::getValue).orElse(null);
  }
}
