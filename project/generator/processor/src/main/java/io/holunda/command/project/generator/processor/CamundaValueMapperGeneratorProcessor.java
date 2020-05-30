package io.holunda.command.project.generator.processor;

import io.holunda.command.project.generator.api.CamundaValueMapperGenerator;
import io.holunda.command.project.generator.processor.template.CamundaValueMapperTemplate;
import io.toolisticon.annotationprocessortoolkit.AbstractAnnotationProcessor;
import io.toolisticon.annotationprocessortoolkit.templating.TemplateProcessor;
import io.toolisticon.annotationprocessortoolkit.tools.ElementUtils.AccessEnclosingElements;
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
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.PackageElement;
import javax.lang.model.element.TypeElement;

@SupportedAnnotationTypes("io.holunda.command.project.generator.annotation.CamundaValueMapperGenerator")
@Service(Processor.class)
public class CamundaValueMapperGeneratorProcessor extends AbstractAnnotationProcessor {

  private final static Class<CamundaValueMapperGenerator> ANNOTATION = CamundaValueMapperGenerator.class;

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
    String packageName = ((PackageElement) AccessEnclosingElements
      .getFirstEnclosingElementOfKind(handlerElement, ElementKind.PACKAGE)).getQualifiedName()
      .toString();

    write(handlerElement, CamundaValueMapperTemplate.builder()
      .packageName(packageName)
      .typeSimpleName("ActivityId")
      .primitiveTypeSimpleName("String")
      .build()
    );
  }

  private void write(Element handlerElement, CamundaValueMapperTemplate template) {

    System.out.println("========= MODEL: " + template);
    System.out.println("========= OUTPUT:" +  TemplateProcessor.processTemplateResourceFile(template.getTemplateResource(), template.getModel()));


    final String filePath = template.getFqn();

    try {
      final SimpleJavaWriter javaWriter = FilerUtils.createSourceFile(filePath, handlerElement);
      javaWriter.writeTemplate(template.getTemplateResource(), template.getModel());
      javaWriter.close();
    } catch (IOException e) {
      MessagerUtils.error(handlerElement, CamundaAnnotationProcessorMessage.ERROR_COULD_NOT_CREATE_VALUE_MAPPER, filePath);
    }
  }
//
//  String filePath = model.get("listenerFqn").toString();
//
//  try {
//  SimpleJavaWriter javaWriter = FilerUtils.createSourceFile(filePath, handlerElement);
//  javaWriter.writeTemplate("/FxKafkaListener.tpl", model);
//  javaWriter.close();
//  } catch (IOException e) {
//  MessagerUtils
//  .error(handlerElement, FxKafkaListenerProcessorMessages.ERROR_COULD_NOT_CREATE_LISTENER,
//  filePath);
//  }
//  }
//
//
//  // ${ packageName }

//  String handlerFqn = ((TypeElement) handlerElement).getQualifiedName().toString();
//  String handlerSimpleName = handlerElement.getSimpleName().toString();
//  String listenerSimpleName = handlerSimpleName.replaceAll("Handler", "Listener");
//  String listenerFqn = packageName.concat(".").concat(listenerSimpleName);
//
//  FxKafkaListener annotation = handlerElement.getAnnotation(FxKafkaListener.class);
//  String containerFactory = escape(annotation.containerFactory());
//  String messageListenerId = annotation.messageListenerId();
//  String topics = Stream.of(annotation.topics()).map(this::escape)
//    .collect(Collectors.joining(","));
//
//  // ${ messageListenerId } -  FxKafkaListener Annotation
//  // ${ topics } -  FxKafkaListener Annotation
//  // ${ containerFactory } -  FxKafkaListener Annotation
//
//  Map<String, Object> model = new HashMap<>();
//
//      model.put("packageName", packageName);
//      model.put("handlerFqn", handlerFqn);
//      model.put("handlerSimpleName", handlerSimpleName);
//      model.put("listenerSimpleName", listenerSimpleName);
//      model.put("listenerFqn", listenerFqn);
//      model.put("containerFactory", containerFactory);
//      model.put("messageListenerId", messageListenerId);
//      model.put("topics", topics);
//
//  write(handlerElement, model);
//
//}
//    return false;
//
//
//      }
//
//private String escape(String value) {
//  return "\"".concat(value).concat("\"");
//  }
//
//private void write(Element handlerElement, Map<String, Object> model) {
//
//  String filePath = model.get("listenerFqn").toString();
//
//  try {
//  SimpleJavaWriter javaWriter = FilerUtils.createSourceFile(filePath, handlerElement);
//  javaWriter.writeTemplate("/FxKafkaListener.tpl", model);
//  javaWriter.close();
//  } catch (IOException e) {
//  MessagerUtils
//  .error(handlerElement, FxKafkaListenerProcessorMessages.ERROR_COULD_NOT_CREATE_LISTENER,
//  filePath);
//  }
//  }


  @Override
  public Set<String> getSupportedAnnotationTypes() {
    return SUPPORTED_ANNOTATIONS;
  }
}
