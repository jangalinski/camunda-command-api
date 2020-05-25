package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.deploymentId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DeploymentIdTest {

  @Test
  public void create() {
    assertThat(deploymentId("12").getValue()).isEqualTo("12");
  }
}
