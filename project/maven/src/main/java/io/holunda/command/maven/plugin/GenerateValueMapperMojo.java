package io.holunda.command.maven.plugin;

import static org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES;
import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME;

import io.holunda.command.maven.plugin.GenerateValueMapperMojo.Type.PrimitiveType;
import io.holunda.command.maven.plugin.util.TemplateLoader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.commons.text.StringSubstitutor;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(
  name = GenerateValueMapperMojo.GOAL,
  defaultPhase = GENERATE_SOURCES,
  requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
public class GenerateValueMapperMojo extends AbstractMojo {

  public static final String GOAL = "generate-value-mapper";

  @Parameter(property = "outputDirectory", required = true, defaultValue = "${project.build.directory}/generated-sources/java")
  protected File outputDirectory;

  @Parameter(property = "packageName", required = true, defaultValue = "io.holunda.command.mapper.value")
  protected String packageName;

  private final TemplateLoader templateLoader = new TemplateLoader();

  @SneakyThrows
  @Override
  public void execute() {
    if (!outputDirectory.exists()) {
      Files.createDirectories(outputDirectory.toPath());
    }

    Path target = Files.createDirectories(outputDirectory.toPath().resolve(packageName.replaceAll("\\.", File.separator)));
    FileUtils.cleanDirectory(target.toFile());

    for (Type type : Arrays.asList(
      new Type("ActivityId"),
      new Type("ActivityInstanceId"),
      new Type("BusinessKey"),
      new Type("CaseDefinitionId"),
      new Type("CaseInstanceId"),
      new Type("DeploymentId"),
      new Type("ExecutionId"),
      new Type("FormKey"),
      new Type("GroupId"),
      new Type("IncidentId"),
      new Type("MessageName"),
      new Type("ProcessDefinitionId"),
      new Type("ProcessDefinitionKey"),
      new Type("ProcessEngineName"),
      new Type("ProcessInstanceId"),
      new Type("TaskDefinitionKey"),
      new Type("TaskId"),
      new Type("TaskPriority", PrimitiveType.Integer),
      new Type("TenantId"),
      new Type("TopicName"),
      new Type("UserId"),
      new Type("VersionTag")
    )) {
      String src = fillTemplate(packageName, type);

      Path path = target.resolve(type.mapperFile);
      byte[] strToBytes = src.getBytes();

      Files.write(path, strToBytes);

    }

  }

  static class Type {

    Type(String typeName) {
      this(typeName, PrimitiveType.String);
    }

    Type(String typeName, PrimitiveType primitiveType) {
      this.typeName = typeName;
      this.mapperFile = typeName + "Mapper.java";
      this.primitiveType = primitiveType.name();
    }

    enum PrimitiveType {
      String, Integer;
    }

    private final String typeName;
    private final String primitiveType;
    private final String mapperFile;

  }



  private String fillTemplate(String packageName, Type type) {

    Map<String,Object> data = new HashMap<>();
    data.put("packageName", packageName);
    data.put("typeName", type.typeName);
    data.put("primitiveType", type.primitiveType);

    return new StringSubstitutor(data).replace(loadTemplate());
  }

  private String loadTemplate() {
    try {
      return templateLoader.loadTemplate("/");
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  };

}
