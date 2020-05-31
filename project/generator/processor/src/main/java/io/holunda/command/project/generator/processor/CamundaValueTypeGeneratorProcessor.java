package io.holunda.command.project.generator.processor;

import io.holunda.command.project.generator.api.CamundaValueTypeGenerator;
import io.holunda.command.project.generator.model.FqnUtil;
import io.holunda.command.project.generator.model.template.CamundaValueTypeImplTemplate;
import io.holunda.command.project.generator.model.template.CamundaValueTypeTemplate;
import io.holunda.command.project.generator.model.template.Template;
import io.holunda.command.project.generator.model.ValueTypeDeclaration;
import io.toolisticon.annotationprocessortoolkit.AbstractAnnotationProcessor;
import io.toolisticon.annotationprocessortoolkit.tools.FilerUtils;
import io.toolisticon.annotationprocessortoolkit.tools.MessagerUtils;
import io.toolisticon.annotationprocessortoolkit.tools.corematcher.CoreMatchers;
import io.toolisticon.annotationprocessortoolkit.tools.fluentvalidator.FluentElementValidator;
import io.toolisticon.annotationprocessortoolkit.tools.generators.SimpleJavaWriter;
import java.io.IOException;
import java.util.Set;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("io.holunda.command.project.generator.api.CamundaValueTypeGenerator")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CamundaValueTypeGeneratorProcessor extends AbstractAnnotationProcessor {


  @Override
  public boolean processAnnotations(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
    roundEnvironment.getElementsAnnotatedWith(CamundaValueTypeGenerator.class).stream()
      .filter(this::filter)
      .forEach(this::process);

    return false;
  }

  public boolean filter(Element handlerElement) {
    return FluentElementValidator.createFluentElementValidator(handlerElement)
      .is(CoreMatchers.IS_INTERFACE)
      .validateAndIssueMessages();
  }

  public void process(Element handlerElement) {
    String packageName = FqnUtil.packageFromElement(handlerElement);

    ValueTypeDeclaration.stream()
      .map(it -> CamundaValueTypeTemplate.builder()
        .packageName(packageName)
        .valueType(it)
        .build())
      .forEach(it -> write(handlerElement, it));

    ValueTypeDeclaration.stream()
      .map(it -> CamundaValueTypeImplTemplate.builder()
        .packageName(packageName.concat(".impl"))
        .valueType(it)
        .build())
      .forEach(it -> write(handlerElement, it));
  }

  private void write(Element handlerElement, Template template) {

    final String filePath = template.getFqn();

    try {
      final SimpleJavaWriter javaWriter = FilerUtils.createSourceFile(filePath, handlerElement);
      javaWriter.writeTemplate(template.getTemplateResourcePath(), template.getModel());
      javaWriter.close();
    } catch (IOException e) {
      MessagerUtils.error(handlerElement, CamundaAnnotationProcessorMessage.ERROR_COULD_NOT_CREATE_VALUE_MAPPER, filePath);
    }
  }
}
