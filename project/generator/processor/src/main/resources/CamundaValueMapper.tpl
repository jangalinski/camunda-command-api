package ${packageName};

import io.holunda.command.api.value.${typeSimpleName};
import io.holunda.command.api.value.impl.${valueTypeSimpleName};
import java.util.Optional;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ${mapperTypeSimpleName} {

  String FROM = "${typeSimpleName}To${primitiveTypeSimpleName}";
  String TO = "${primitiveTypeSimpleName}To${typeSimpleName}";

  ${mapperTypeSimpleName} INSTANCE = Mappers.getMapper(${mapperTypeSimpleName}.class);

  @Named(${mapperTypeSimpleName}.TO)
  default ${typeSimpleName} convert(${primitiveTypeSimpleName} value) {
    return ${typeSimpleName}Value.of(value);
  }

  @Named(${mapperTypeSimpleName}.TO)
  default Optional<${typeSimpleName}> convertOptional(${primitiveTypeSimpleName} value) {
    return Optional.ofNullable(value).map(${typeSimpleName}Value::of);
  }

  @Named(${mapperTypeSimpleName}.FROM)
  default ${primitiveTypeSimpleName} convert(final ${typeSimpleName} value) {
    return value.getValue();
  }

  @Named(${mapperTypeSimpleName}.FROM)
  default ${primitiveTypeSimpleName} convertOptional(final Optional<${typeSimpleName}> value) {
    return value.map(${typeSimpleName}::getValue).orElse(null);
  }
}
