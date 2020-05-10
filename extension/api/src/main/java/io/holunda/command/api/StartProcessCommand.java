package io.holunda.command.api;

import io.holunda.command.api.CamundaCommandApi.CamundaCommand;
import io.holunda.command.api.model.BusinessKey;
import io.holunda.command.api.model.CaseInstanceId;
import io.holunda.command.api.model.Immutables.ImmutableObject;
import io.holunda.command.api.model.MessageName;
import io.holunda.command.api.model.ProcessDefinitionId;
import io.holunda.command.api.model.ProcessDefinitionKey;
import java.util.Optional;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.jetbrains.annotations.NotNull;

public interface StartProcessCommand extends CamundaCommand {

  static StartProcessByKeyCommand.Builder byKey(@NotNull final ProcessDefinitionKey processDefinitionKey) {
    return StartProcessByKeyCommand.builder()
      .processDefinitionKey(processDefinitionKey);
  }

  static StartProcessByIdCommand.Builder byId(@NotNull final ProcessDefinitionId processDefinitionId) {
    return StartProcessByIdCommand.builder()
      .processDefinitionId(processDefinitionId);
  }

  static StartProcessByMessageCommand.Builder byMessage(@NotNull final MessageName messageName) {
    return StartProcessByMessageCommand.builder()
      .messageName(messageName);
  }

  static StartProcessByMessageAndIdCommand.Builder byMessage(@NotNull final MessageName messageName, @NotNull final ProcessDefinitionId processDefinitionId) {
    return StartProcessByMessageAndIdCommand.builder()
      .messageName(messageName)
      .processDefinitionId(processDefinitionId);
  }

  @Value.Immutable
  @ImmutableObject
  interface _StartProcessByKeyCommand extends StartProcessCommand {

    /**
     * @return key of process definition, cannot be null
     */
    ProcessDefinitionKey getProcessDefinitionKey();
  }

  @Value.Immutable
  @ImmutableObject
  interface _StartProcessByIdCommand extends StartProcessCommand {

    /**
     * @return the id of the process definition, cannot be null.
     */
    ProcessDefinitionId getProcessDefinitionId();

  }

  @Value.Immutable
  @ImmutableObject
  interface _StartProcessByMessageCommand extends StartProcessCommand {

    /**
     * @return the 'name' of the message as specified as an attribute on the bpmn20 {@code <message name="messageName" />}
     */
    MessageName getMessageName();

  }

  @Value.Immutable
  @ImmutableObject
  interface _StartProcessByMessageAndIdCommand extends StartProcessCommand {

    /**
     * @return the 'name' of the message as specified as an attribute on the bpmn20 {@code <message name="messageName" />}
     */
    MessageName getMessageName();

    /**
     * @return the id of the process definition, cannot be null.
     */
    ProcessDefinitionId getProcessDefinitionId();
  }

  /**
   * @return a key that uniquely identifies the process instance in the context of the given process definition.
   */
  Optional<BusinessKey> getBusinessKey();

  /**
   * @return the variables to pass, empty by default.
   */
  @Value.Default
  default VariableMap getVariables() {
    return Variables.createVariables();
  }

  @Value.Default
  default boolean isReturnWithVariables() {
    return false;
  }

  /**
   * @return an id of a case instance to associate the process instance with a case instance.
   */
  Optional<CaseInstanceId> getCaseInstanceId();

}
