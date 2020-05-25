package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.versionTag;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class VersionTagTest {

  @Test
  public void create() {
    assertThat(versionTag("1").getValue()).isEqualTo("1");
  }
}
