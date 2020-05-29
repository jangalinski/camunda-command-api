package io.holunda.command.project.generator.processor;

import io.toolisticon.annotationprocessortoolkit.tools.MessagerUtils;
import io.toolisticon.compiletesting.CompileTestBuilder;
import javax.tools.JavaFileObject.Kind;
import javax.tools.StandardLocation;
import org.junit.Before;
import org.junit.Test;

public class CamundaValueMapperGeneratorProcessorTest {

  private final CompileTestBuilder.CompilationTestBuilder compileTestBuilder = CompileTestBuilder
    .compilationTest()
    .addProcessors(CamundaValueMapperGeneratorProcessor.class);

  @Before
  public void init() {
    MessagerUtils.setPrintMessageCodes(true);
  }


  @Test
  public void name() {
    compileTestBuilder
      .addSources("/processor/_CamundaValueMappersGenerator.java")
      .compilationShouldSucceed()
      .expectedJavaFileObjectExists(StandardLocation.SOURCE_OUTPUT,"io.holunda.command.mapper.value.ActivityIdMapper", Kind.SOURCE)
      .
      ;
      //.testCompilation();
  }
}
