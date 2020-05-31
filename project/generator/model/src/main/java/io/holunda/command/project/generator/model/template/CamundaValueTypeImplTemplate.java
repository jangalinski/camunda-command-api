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
public class CamundaValueTypeImplTemplate implements Template {

  @NonNull
  ValueTypeDeclaration valueType;

  @NonNull
  String packageName;

  @Getter(lazy = true)
  String typeSimpleName = getValueType().name();

  @Getter(lazy = true)
  String valueWrapperTypeSimpleName = "NonEmptyStringValueWrapper";

  @Getter(lazy = true)
  String primitiveTypeSimpleName= getValueType().getPrimitiveType().getTypeSimpleName();

  @Getter(lazy = true)
  String fqn = getPackageName().concat("._").concat(getTypeSimpleName());


  @Override
  public Map<String, Object> getModel() {
    final Map<String, Object> model = new HashMap<>();
    model.put("packageName", getPackageName());
    model.put("typeSimpleName", getTypeSimpleName());
    model.put("primitiveTypeSimpleName", getPrimitiveTypeSimpleName());
    model.put("valueWrapperTypeSimpleName", getValueWrapperTypeSimpleName());

    return model;
  }

  public String process() {
    return TemplateProcessor.processTemplateResourceFile(getTemplateResourcePath(), getModel());
  }
}
