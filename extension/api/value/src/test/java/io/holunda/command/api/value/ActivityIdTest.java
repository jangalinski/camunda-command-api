package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.activityId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ActivityIdTest {

  @Test
  public void create() {
    assertThat(activityId("activity").getValue()).isEqualTo("activity");
  }
}
