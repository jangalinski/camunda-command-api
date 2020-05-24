package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.businessKey;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class BusinessKeyTest {

  @Test
  public void fail_to_create_with_empty() {
    assertThatThrownBy(() -> businessKey("   "))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("string value must not be null or empty");
  }

  @Test
  public void create_value() {
    assertThat(businessKey("1").getValue()).isEqualTo("1");
  }
}
