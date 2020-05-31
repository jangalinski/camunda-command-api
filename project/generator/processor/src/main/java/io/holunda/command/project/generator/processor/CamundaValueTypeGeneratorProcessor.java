package io.holunda.command.project.generator.processor;

import io.holunda.command.project.generator.api.CamundaValueTypeGenerator;
import io.holunda.command.project.generator.processor.model.FqnUtil;
import io.holunda.command.project.generator.api.model.ValueTypeDeclaration;
import io.holunda.command.project.generator.processor.template.CamundaValueTypeTemplate;
import io.holunda.command.project.generator.processor.template.Template;
import io.toolisticon.annotationprocessortoolkit.AbstractAnnotationProcessor;
import io.toolisticon.annotationprocessortoolkit.tools.FilerUtils;
import io.toolisticon.annotationprocessortoolkit.tools.MessagerUtils;
import io.toolisticon.annotationprocessortoolkit.tools.corematcher.CoreMatchers;
import io.toolisticon.annotationprocessortoolkit.tools.fluentvalidator.FluentElementValidator;
import io.toolisticon.annotationprocessortoolkit.tools.generators.SimpleJavaWriter;
import io.toolisticon.spiap.api.Service;
import java.io.IOException;
import java.util.Set;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("io.holunda.command.project.generator.annotation.CamundaValueTypeGenerator")
@Service(Processor.class)
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class CamundaValueTypeGeneratorProcessor extends AbstractAnnotationProcessor {

  private final static Class<CamundaValueTypeGenerator> ANNOTATION = CamundaValueTypeGenerator.class;

  private final static Set<String> SUPPORTED_ANNOTATIONS = createSupportedAnnotationSet(ANNOTATION);

  @Override
  public boolean processAnnotations(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
    roundEnvironment.getElementsAnnotatedWith(ANNOTATION).stream()
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

  @Override
  public Set<String> getSupportedAnnotationTypes() {
    return SUPPORTED_ANNOTATIONS;
  }
}
