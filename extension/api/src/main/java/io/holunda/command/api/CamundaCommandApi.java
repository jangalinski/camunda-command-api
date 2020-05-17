package io.holunda.command.api;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaStringValue;
import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.DeploymentId;
import io.holunda.command.api.value.MessageName;
import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.impl.BusinessKeyValue;
import io.holunda.command.api.value.impl.CaseInstanceIdValue;
import io.holunda.command.api.value.impl.DeploymentIdValue;
import io.holunda.command.api.value.impl.MessageNameValue;
import io.holunda.command.api.value.impl.ProcessDefinitionIdValue;
import io.holunda.command.api.value.impl.ProcessDefinitionKeyValue;
import io.holunda.command.api.value.impl.ProcessInstanceIdValue;
import io.holunda.command.api.value.impl.TaskIdValue;
import io.holunda.command.api.value.impl.TenantIdValue;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

public final class CamundaCommandApi {

  public static BusinessKey businessKey(String value) {
    return BusinessKeyValue.of(value);
  }

  public static CaseInstanceId caseInstanceId(String value) {
    return CaseInstanceIdValue.of(value);
  }

  public static DeploymentId deploymentId(String value) {
    return DeploymentIdValue.of(value);
  }

  public static MessageName messageName(String value) {
    return MessageNameValue.of(value);
  }

  public static ProcessDefinitionId processDefinitionId(String value) {
    return ProcessDefinitionIdValue.of(value);
  }

  public static ProcessDefinitionKey processDefinitionKey(String value) {
    return ProcessDefinitionKeyValue.of(value);
  }

  public static ProcessInstanceId processInstanceId(String value) {
    return ProcessInstanceIdValue.of(value);
  }

  public static TaskId taskId(String value) {
    return TaskIdValue.of(value);
  }

  public static TenantId tenantId(String value) {
    return TenantIdValue.of(value);
  }

  interface CamundaCommand {
    // empty marker interface
  }

  interface CamundaEvent {
    // empty marker interface
  }

  interface CamundaQuery {
    // empty marker interface
  }

  public static final class Immutables {

    @Value.Style(
      // Detect names starting with underscore
      typeAbstract = "_*",
      // Generate without any suffix, just raw detected name
      typeImmutable = "*",
      // Make generated public, leave underscored as package private
      visibility = ImplementationVisibility.PUBLIC,
      // Seems unnecessary to have builder or superfluous copy method
      defaults = @Value.Immutable(builder = true, copy = true))
    public @interface ImmutableObject {
      // empty annotation
    }
  }

  private CamundaCommandApi() {
    // util class
  }
}
