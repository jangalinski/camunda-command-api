package io.holunda.command.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import io.holunda.command.api.model.MessageName;
import io.holunda.command.api.model.ProcessDefinitionId;
import io.holunda.command.api.model.ProcessDefinitionKey;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

@RunWith(Enclosed.class)
public class StartProcessCommandTest {

  private static final ProcessDefinitionKey PROCESS_DEFINITION_KEY = ProcessDefinitionKey.of(UUID.randomUUID().toString());
  private static final ProcessDefinitionId PROCESS_DEFINITION_ID = ProcessDefinitionId.of(UUID.randomUUID().toString());
  private static final MessageName MESSAGE_NAME = MessageName.of("message");


  public static class StartProcessByKeyTest {

    @Test
    public void cannot_create_without_required_fields() {
      assertThatThrownBy(() -> StartProcessByKeyCommand.builder().build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("[processDefinitionKey]");
    }

    @Test
    public void default_values_for_non_required_fields() {
      StartProcessByKeyCommand command = StartProcessCommand.byKey(PROCESS_DEFINITION_KEY).build();

      assertThat(command.getProcessDefinitionKey()).isEqualTo(PROCESS_DEFINITION_KEY);
      assertThat(command.getBusinessKey()).isEmpty();
      assertThat(command.getCaseInstanceId()).isEmpty();
      assertThat(command.getVariables()).isEmpty();
      assertThat(command.isReturnWithVariables()).isFalse();
    }
  }

  public static class StartProcessByIdTest {

    @Test
    public void cannot_create_without_required_fields() {
      assertThatThrownBy(() -> StartProcessByIdCommand.builder().build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("[processDefinitionId]");
    }

    @Test
    public void default_values_for_non_required_fields() {
      StartProcessByIdCommand command = StartProcessCommand.byId(PROCESS_DEFINITION_ID).build();

      assertThat(command.getProcessDefinitionId()).isEqualTo(PROCESS_DEFINITION_ID);
      assertThat(command.getBusinessKey()).isEmpty();
      assertThat(command.getCaseInstanceId()).isEmpty();
      assertThat(command.getVariables()).isEmpty();
      assertThat(command.isReturnWithVariables()).isFalse();
    }
  }

  public static class StartProcessByMessageTest {

    @Test
    public void cannot_create_without_required_fields() {
      assertThatThrownBy(() -> StartProcessByMessageCommand.builder().build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("[messageName]");
    }

    @Test
    public void default_values_for_non_required_fields() {
      StartProcessByMessageCommand command = StartProcessCommand.byMessage(MESSAGE_NAME).build();

      assertThat(command.getMessageName()).isEqualTo(MESSAGE_NAME);
      assertThat(command.getBusinessKey()).isEmpty();
      assertThat(command.getCaseInstanceId()).isEmpty();
      assertThat(command.getVariables()).isEmpty();
      assertThat(command.isReturnWithVariables()).isFalse();
    }
  }

  public static class StartProcessByMessageAndIdTest {

    @Test
    public void cannot_create_without_required_fields() {
      assertThatThrownBy(() -> StartProcessByMessageAndIdCommand.builder().build())
        .isInstanceOf(IllegalStateException.class)
        .hasMessageContaining("[messageName, processDefinitionId]");
    }

    @Test
    public void default_values_for_non_required_fields() {
      StartProcessByMessageAndIdCommand command = StartProcessCommand.byMessage(MESSAGE_NAME, PROCESS_DEFINITION_ID).build();

      assertThat(command.getMessageName()).isEqualTo(MESSAGE_NAME);
      assertThat(command.getProcessDefinitionId()).isEqualTo(PROCESS_DEFINITION_ID);
      assertThat(command.getBusinessKey()).isEmpty();
      assertThat(command.getCaseInstanceId()).isEmpty();
      assertThat(command.getVariables()).isEmpty();
      assertThat(command.isReturnWithVariables()).isFalse();
    }
  }
}
