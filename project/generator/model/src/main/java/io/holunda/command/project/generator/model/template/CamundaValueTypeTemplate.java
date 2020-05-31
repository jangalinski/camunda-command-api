package io.holunda.command.project.generator.model.template;

import io.holunda.command.project.generator.model.ValueTypeDeclaration;
import io.toolisticon.annotationprocessortoolkit.templating.TemplateProcessor;
import java.util.HashMap;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Value;

@Value
@Builder
public class CamundaValueTypeTemplate implements Template {

  @NonNull
  ValueTypeDeclaration valueType;

  @NonNull
  String packageName;

  @Getter(lazy = true)
  String typeSimpleName = getValueType().name();

  @Getter(lazy = true)
  String primitiveTypeSimpleName= getValueType().getPrimitiveType().getTypeSimpleName();

  @Override
  public Map<String, Object> getModel() {
    final Map<String, Object> model = new HashMap<>();
    model.put("packageName", getPackageName());
    model.put("typeSimpleName", getTypeSimpleName());
    model.put("primitiveTypeSimpleName", getPrimitiveTypeSimpleName());

    return model;
  }

  public String process() {
    return TemplateProcessor.processTemplateResourceFile(getTemplateResourcePath(), getModel());
  }
}
