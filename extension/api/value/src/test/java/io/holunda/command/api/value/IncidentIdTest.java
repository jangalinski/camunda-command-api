package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.groupId;
import static io.holunda.command.api.value.CamundaValues.incidentId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IncidentIdTest {

  @Test
  public void create() {
    assertThat(incidentId("1").getValue()).isEqualTo("1");
  }
}
