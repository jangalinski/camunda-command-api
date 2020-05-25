package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.tenantId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class TenantIdTest {

  @Test
  public void create() {
    assertThat(tenantId("tenant").getValue()).isEqualTo("tenant");
  }
}
