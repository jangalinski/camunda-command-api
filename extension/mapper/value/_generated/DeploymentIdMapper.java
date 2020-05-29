package io.holunda.command.mapper.value;

import io.holunda.command.api.value.DeploymentId;
import io.holunda.command.api.value.impl.DeploymentIdValue;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DeploymentIdMapper {

  String FROM = "DeploymentIdToString";
  String TO = "StringToDeploymentId";

  DeploymentIdMapper INSTANCE = Mappers.getMapper(DeploymentIdMapper.class);

  @Named(DeploymentIdMapper.TO)
  default DeploymentId convert(String value) {
    return DeploymentIdValue.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<DeploymentId> convertOptional(String value) {
    return Optional.ofNullable(value).map(DeploymentIdValue::of);
  }

  @Named(DeploymentIdMapper.FROM)
  default String convert(final DeploymentId value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default String convertOptional(final Optional<DeploymentId> value) {
    return value.map(DeploymentId::getValue).orElse(null);
  }
}
