package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.formKey;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FormKeyTest {

  @Test
  public void create() {
    assertThat(formKey("form://key").getValue()).isEqualTo("form://key");
  }
}
