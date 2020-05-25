package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.userId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class UserIdTest {

  @Test
  public void create() {
    assertThat(userId("kermit").getValue()).isEqualTo("kermit");
  }
}
