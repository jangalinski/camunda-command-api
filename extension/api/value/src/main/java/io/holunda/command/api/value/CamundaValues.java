package io.holunda.command.api.value;

import io.holunda.command.api.value.impl.ActivityIdValue;
import io.holunda.command.api.value.impl.BusinessKeyValue;
import io.holunda.command.api.value.impl.CaseDefinitionIdValue;
import io.holunda.command.api.value.impl.CaseInstanceIdValue;
import io.holunda.command.api.value.impl.DeploymentIdValue;
import io.holunda.command.api.value.impl.ExecutionIdValue;
import io.holunda.command.api.value.impl.FormKeyValue;
import io.holunda.command.api.value.impl.GroupIdValue;
import io.holunda.command.api.value.impl.IncidentIdValue;
import io.holunda.command.api.value.impl.MessageNameValue;
import io.holunda.command.api.value.impl.ProcessDefinitionIdValue;
import io.holunda.command.api.value.impl.ProcessDefinitionKeyValue;
import io.holunda.command.api.value.impl.ProcessEngineNameValue;
import io.holunda.command.api.value.impl.ProcessInstanceIdValue;
import io.holunda.command.api.value.impl.TaskDefinitionKeyValue;
import io.holunda.command.api.value.impl.TaskIdValue;
import io.holunda.command.api.value.impl.TaskPriorityValue;
import io.holunda.command.api.value.impl.TenantIdValue;
import io.holunda.command.api.value.impl.TopicNameValue;
import io.holunda.command.api.value.impl.UserIdValue;
import io.holunda.command.api.value.impl.VersionTagValue;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

public final class CamundaValues {

  public static final ProcessEngineName DEFAULT_PROCESS_ENGINE_NAME = ProcessEngineNameValue.of("default");

  public static ActivityId activityId(@NotNull final String value) {
    return ActivityIdValue.of(value);
  }

  public static BusinessKey businessKey(@NotNull final String value) {
    return BusinessKeyValue.of(value);
  }

  public static CaseDefinitionId caseDefinitionId(@NotNull final String value) {
    return CaseDefinitionIdValue.of(value);
  }

  public static CaseInstanceId caseInstanceId(@NotNull final String value) {
    return CaseInstanceIdValue.of(value);
  }

  public static DeploymentId deploymentId(@NotNull final String value) {
    return DeploymentIdValue.of(value);
  }

  public static ExecutionId executionId(@NotNull final String value) {
    return ExecutionIdValue.of(value);
  }

  public static FormKey formKey(@NotNull final String value) {
    return FormKeyValue.of(value);
  }

  public static GroupId groupId(@NotNull final String value) {
    return GroupIdValue.of(value);
  }

  public static IncidentId incidentId(@NotNull final String value) {
    return IncidentIdValue.of(value);
  }

  public static MessageName messageName(@NotNull final String value) {
    return MessageNameValue.of(value);
  }

  public static ProcessDefinitionId processDefinitionId(@NotNull final String value) {
    return ProcessDefinitionIdValue.of(value);
  }

  public static ProcessDefinitionKey processDefinitionKey(@NotNull final String value) {
    return ProcessDefinitionKeyValue.of(value);
  }

  public static ProcessEngineName processEngineName(@NotNull final String value) {
    return ProcessEngineNameValue.of(value);
  }

  public static ProcessInstanceId processInstanceId(@NotNull final String value) {
    return ProcessInstanceIdValue.of(value);
  }

  public static TaskDefinitionKey taskDefinitionKey(@NotNull final String value) {
    return TaskDefinitionKeyValue.of(value);
  }

  public static TaskId taskId(@NotNull final String value) {
    return TaskIdValue.of(value);
  }

  public static TaskPriority taskPriority(final int value) {
    return TaskPriorityValue.of(value);
  }

  public static TenantId tenantId(@NotNull final String value) {
    return TenantIdValue.of(value);
  }

  public static TopicName topicName(@NotNull final String value) {
    return TopicNameValue.of(value);
  }

  public static UserId userId(@NotNull final String value) {
    return UserIdValue.of(value);
  }

  public static VersionTag versionTag(@NotNull final String value) {
    return VersionTagValue.of(value);
  }

  public interface CamundaStringValue extends Serializable {

    String getValue();
  }

  public interface CamundaLongValue extends Serializable {

    Long getValue();
  }

  public interface CamundaIntValue extends Serializable {

    Integer getValue();
  }

  private CamundaValues() {
    // empty, do not instantiate
  }
}
