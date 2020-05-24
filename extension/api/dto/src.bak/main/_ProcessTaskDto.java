package io.holunda.command.api.dto;

import io.holunda.command.api.CamundaCommandApi.Immutables.ImmutableObject;
import io.holunda.command.api.value.ExecutionId;
import io.holunda.command.api.value.FormKey;
import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.TaskDefinitionKey;
import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.TaskPriority;
import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.UserId;
import java.util.Date;
import java.util.Optional;
import org.camunda.bpm.engine.task.DelegationState;
import org.immutables.value.Value;

@Value.Immutable
@ImmutableObject
interface _ProcessTaskDto extends _TaskDto {

  TaskId getId();
  TaskDefinitionKey getTaskDefinitionKey();

  String getName();

  Optional<String> getDescription();

  TaskPriority getPriority();

  UserId getOwner();

  UserId getAssignee();

  DelegationState getDelegationState();

  ProcessInstanceId getProcessInstanceId();
  ExecutionId getExecutionId();
  ProcessDefinitionId getProcessDefinitionId();

  Date  getCreateTime();
  Date getDueDate();

  Date getFollowUpDate();

    /** the parent task for which this task is a subtask */
  TaskId getParentTaskId();

    /** Indicated whether this task is suspended or not. */
    boolean isSuspended();

    FormKey getFormKey();

    Optional<TenantId> getTenantId();

}
