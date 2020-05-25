package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.groupId;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class GroupIdTest {

  @Test
  public void create() {
    assertThat(groupId("group").getValue()).isEqualTo("group");
  }
}
