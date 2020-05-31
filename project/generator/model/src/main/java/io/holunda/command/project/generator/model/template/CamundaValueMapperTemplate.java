package io.holunda.command.project.generator.model.template;

import io.toolisticon.annotationprocessortoolkit.templating.TemplateProcessor;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class CamundaValueMapperTemplate {

  @NonNull
  String packageName;

  @NonNull
  String typeSimpleName;

  @NonNull
  String primitiveTypeSimpleName;

  @Getter(lazy = true)
  String mapperTypeSimpleName = typeSimpleName.concat("Mapper");

  @Getter(lazy = true)
  String valueTypeSimpleName = typeSimpleName.concat("Value");

  @Getter(lazy = true)
  String templateResource = "/CamundaValueMapper.tpl";

  @Getter(lazy = true)
  String fqn = packageName.concat(".").concat(getMapperTypeSimpleName());

  public Map<String, Object> getModel() {
    final Map<String, Object> model = new HashMap<>();
    model.put("packageName", getPackageName());
    model.put("typeSimpleName", getTypeSimpleName());
    model.put("primitiveTypeSimpleName", getPrimitiveTypeSimpleName());
    model.put("valueTypeSimpleName", getValueTypeSimpleName());
    model.put("mapperTypeSimpleName", getMapperTypeSimpleName());

    return model;
  }

  public String process() {
    return TemplateProcessor.processTemplateResourceFile(getTemplateResource(), getModel());
  }
}
