package io.holunda.command.project.generator.processor.template;

import io.holunda.command.project.generator.processor.model.ValueTypeDeclaration;
import org.junit.Test;

public class CamundaValueTypeTemplateTest {

  @Test
  public void name() {
    CamundaValueTypeTemplate tpl = CamundaValueTypeTemplate.builder()
      .packageName("io.holunda.command.api.value")
      .valueType(ValueTypeDeclaration.ActivityId)
      .build();

    System.out.println(tpl.process());
  }
}
