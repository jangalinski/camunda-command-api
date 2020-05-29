package io.holunda.command.mapper.value;

import java.util.Map;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;

public final class CamundaValueMappers {

  @MapperConfig(uses = {

  })
  public static class CamundaValueMapperConfig {

  }



  @Mapper
  public interface VariableMapMapper {

    default VariableMap convert(Map<String,Object> value) {
      return Variables.fromMap(value);
    }



  }

  private CamundaValueMappers() {
    // do not instantiate
  }
}
