package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.processInstanceId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProcessInstanceIdTest {

  @Test
  public void create() {
    assertThat(processInstanceId("12").getValue()).isEqualTo("12");
  }
}
