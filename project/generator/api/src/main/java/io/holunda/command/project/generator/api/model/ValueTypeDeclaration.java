package io.holunda.command.project.generator.api.model;

import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum ValueTypeDeclaration {
  ActivityId(PrimitiveType.STRING),
  ActivityInstanceId(PrimitiveType.STRING),
  BusinessKey(PrimitiveType.STRING),
  CamundaValues(PrimitiveType.STRING),
  CaseDefinitionId(PrimitiveType.STRING),
  CaseInstanceId(PrimitiveType.STRING),
  DeploymentId(PrimitiveType.STRING),
  ExecutionId(PrimitiveType.STRING),
  FormKey(PrimitiveType.STRING),
  GroupId(PrimitiveType.STRING),
  IncidentId(PrimitiveType.STRING),
  MessageName(PrimitiveType.STRING),
  ProcessDefinitionId(PrimitiveType.STRING),
  ProcessDefinitionKey(PrimitiveType.STRING),
  ProcessEngineName(PrimitiveType.STRING),
  ProcessInstanceId(PrimitiveType.STRING),
  TaskDefinitionKey(PrimitiveType.STRING),
  TaskId(PrimitiveType.STRING),
  // TODO deal with integer and additional enum TaskPriority(PrimitiveType.INTEGER),
  TaskPriorityLabel(PrimitiveType.STRING),
  TenantId(PrimitiveType.STRING),
  TopicName(PrimitiveType.STRING),
  UserId(PrimitiveType.STRING),
  VersionTag(PrimitiveType.STRING),
  ;

  @Getter
  private final PrimitiveType primitiveType;

  public static Stream<ValueTypeDeclaration> stream() {
    return Stream.of(values());
  }
}
