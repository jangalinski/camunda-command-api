package io.holunda.command.api;

import io.holunda.command.api.CamundaCommandApi.CamundaCommand;
import io.holunda.command.api.model.Immutables.ImmutableObject;
import io.holunda.command.api.model.ProcessInstanceId;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.runtime.ProcessInstanceQuery;
import org.immutables.value.Value;
import org.jetbrains.annotations.Nullable;

// TODO: simple way to create command for single instance
@Value.Immutable
@ImmutableObject
interface _DeleteProcessInstanceCommand extends CamundaCommand {

  /**
   * @return id's of process instances to delete, cannot be null if processInstanceQuery is null.
   */
  @Value.Default
  default List<ProcessInstanceId> getProcessInstanceIds() {
    return Collections.emptyList();
  }

  /**
   * @return query that will be used to fetch affected process instances. Cannot be null if processInstanceIds are null.
   */
  Optional<ProcessInstanceQuery> getProcessInstanceQuery();

  /**
   * @return reason for deleting, which will be stored in the history. Can be null.
   */
  @Nullable
  String getDeleteReason();

  @Value.Default
  default boolean isProcessAsync() {
    return false;
  }

  /**
   * @return if true, only the built-in {@link ExecutionListener}s are notified with the {@link ExecutionListener#EVENTNAME_END} event.
   */
  @Value.Default
  default boolean isSkipCustomListeners() {
    return false;
  }

  @Value.Default
  default boolean isSkipSubprocesses() {
    return false;
  }

  /**
   * @return specifies whether input/output mappings for tasks should be invoked
   */
  @Value.Default
  default boolean isSkipIoMappings() {
    return false;
  }

  /**
   * @return indicator if deletion triggered from external context, for instance REST API call
   */
  @Value.Default
  default boolean isExternallyTerminated() {
    return false;
  }

  @Value.Default
  default boolean isFailIfProcessInstanceNotFound() {
    return true;
  }


}
