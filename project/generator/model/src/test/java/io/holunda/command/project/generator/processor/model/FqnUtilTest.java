package io.holunda.command.project.generator.processor.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.holunda.command.project.generator.model.FqnUtil;
import org.junit.Test;

public class FqnUtilTest {

  @Test
  public void resourcePath_gets_path_from_basePackage() {
    assertThat(FqnUtil.resourcePath("io.holunda.command.foo.bar")).isEqualTo("/foo/bar");
  }

  @Test
  public void resourcePath_fails_when_not_part_of_basePackage() {
    assertThatThrownBy(() -> FqnUtil.resourcePath("io.toolisticon.command.foo.bar"))
      .isInstanceOf(IllegalArgumentException.class);
  }
}
