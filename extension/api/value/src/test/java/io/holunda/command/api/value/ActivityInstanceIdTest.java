package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.activityInstanceId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ActivityInstanceIdTest {

  @Test
  public void create() {
    assertThat(activityInstanceId("12").getValue()).isEqualTo("12");
  }
}
