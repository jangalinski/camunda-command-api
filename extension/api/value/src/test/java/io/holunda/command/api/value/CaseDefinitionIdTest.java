package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.caseDefinitionId;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.Test;

public class CaseDefinitionIdTest {

  @Test
  public void fail_to_create_with_empty() {
    assertThatThrownBy(() -> caseDefinitionId("   "))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessage("string value must not be null or empty");
  }

  @Test
  public void create_value() {
    assertThat(caseDefinitionId("1").getValue()).isEqualTo("1");
  }
}
