package io.holunda.command.api.dto;

import io.holunda.command.api.CamundaCommandApi.CamundaDto;
import io.holunda.command.api.value.FormKey;
import io.holunda.command.api.value.TaskDefinitionKey;
import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.TaskPriority;
import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.UserId;
import java.util.Date;
import java.util.Optional;
import org.camunda.bpm.engine.task.DelegationState;

public interface _TaskDto extends CamundaDto {

  TaskId getId();

  String getName();

  Optional<String> getDescription();

  TaskPriority getPriority();

  UserId getOwner();

  UserId getAssignee();

  DelegationState getDelegationState();

//  Optional<ProcessInstanceId> getProcessInstanceId();
//  Optional<ExecutionId> getExecutionId();
//  Optional<ProcessDefinitionId> getProcessDefinitionId();
//  Optional<CaseInstanceId> getCaseInstanceId();
//  Optional<ExecutionId> getCaseExecutionId();
//  Optional<ProcessDefinitionId> getCaseDefinitionId();

  Date  getCreateTime();
  TaskDefinitionKey getTaskDefinitionKey();

  Date getDueDate();

      Date getFollowUpDate();

    /** the parent task for which this task is a subtask */
TaskId getParentTaskId();

    /** Indicated whether this task is suspended or not. */
    boolean isSuspended();

    FormKey getFormKey();

  Optional<TenantId> getTenantId();

}
