package io.holunda.command.api.value;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.holunda.command.api.CamundaCommandApi;
import org.junit.Test;

public class BusinessKeyTest {

  @Test
  public void fail_to_create_with_empty() {
    assertThatThrownBy(() -> CamundaCommandApi.businessKey("   "))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("string value must not be null or empty");
  }

}
