package io.holunda.command.api.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class ModelTest {

  @Test
  public void businessKey() {
    assertThat(BusinessKey.of("1").value()).isEqualTo("1");

    assertThatThrownBy(() -> BusinessKey.of("   "))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining("null or empty");
  }
}
