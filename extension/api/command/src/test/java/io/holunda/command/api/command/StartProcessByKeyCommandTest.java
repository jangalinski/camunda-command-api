package io.holunda.command.api.command;

import static io.holunda.command.api.value.CamundaValues.businessKey;
import static io.holunda.command.api.value.CamundaValues.processDefinitionKey;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class StartProcessByKeyCommandTest {

  @Test
  public void create_minimal() {
    StartProcessByKeyCommand command = StartProcessCommand.byKey(processDefinitionKey("a"))
      .businessKey(businessKey("11"))
      .build();

    assertThat(command.getProcessEngineName().getValue()).isEqualTo("default");
  }
}
