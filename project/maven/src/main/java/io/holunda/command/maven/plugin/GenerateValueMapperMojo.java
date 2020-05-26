package io.holunda.command.maven.plugin;

import static org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES;
import static org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(
  name = GenerateValueMapperMojo.GOAL,
  defaultPhase = GENERATE_SOURCES,
  requiresDependencyResolution = COMPILE_PLUS_RUNTIME
)
public class GenerateValueMapperMojo extends AbstractMojo {

  public static final String GOAL = "generate-value-mapper";

  @Override
  public void execute() {
    getLog().info(""
      + "\n"
      + "\n"
      + "\n"
      + "\n"
      + "----------            WITHIN PLUGIN"
      + "\n"
      + "\n"
      + "\n"
      + "\n"
      + "");
  }
}
