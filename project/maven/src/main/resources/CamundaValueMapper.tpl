package ${packageName};

import io.holunda.command.api.value.${typeName};
import io.holunda.command.api.value.impl.${typeName}Value;
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ${typeName}Mapper {

  String FROM = "${typeName}To${primitiveType}";
  String TO = "${primitiveType}To${typeName}";

  ${typeName}Mapper INSTANCE = Mappers.getMapper(${typeName}Mapper.class);

  @Named(${typeName}Mapper.TO)
  default ${typeName} convert(${primitiveType} value) {
    return ${typeName}Value.of(value);
  }

  @Named(VersionTagMapper.TO)
  default Optional<${typeName}> convertOptional(${primitiveType} value) {
    return Optional.ofNullable(value).map(${typeName}Value::of);
  }

  @Named(${typeName}Mapper.FROM)
  default ${primitiveType} convert(final ${typeName} value) {
    return value.getValue();
  }

  @Named(ProcessInstanceIdMapper.FROM)
  default ${primitiveType} convertOptional(final Optional<${typeName}> value) {
    return value.map(${typeName}::getValue).orElse(null);
  }
}
