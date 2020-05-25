package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.incidentId;
import static io.holunda.command.api.value.CamundaValues.messageName;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class MessageNameTest {

  @Test
  public void create() {
    assertThat(messageName("msg").getValue()).isEqualTo("msg");
  }
}
