package io.holunda.command.project.generator.processor.template;

import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.project.generator.model.template.CamundaValueTypeTemplate;
import io.holunda.command.project.generator.model.ValueTypeDeclaration;
import org.junit.Test;

public class CamundaValueTypeTemplateTest {

  @Test
  public void generate_activityId_interface() {
    final CamundaValueTypeTemplate tpl = CamundaValueTypeTemplate.builder()
      .packageName("io.holunda.command.api.value")
      .valueType(ValueTypeDeclaration.ActivityId)
      .build();

    assertThat(tpl.process()).isEqualTo("package io.holunda.command.api.value;\n"
      + "\n"
      + "public interface ActivityId extends CamundaValues.CamundaStringValue {\n"
      + "  // empty type declaration\n"
      + "}"
      + "\n");
  }
}
