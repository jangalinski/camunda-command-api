package io.holunda.command.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import io.holunda.command.api.value.ActivityId;
import io.holunda.command.api.value.ActivityInstanceId;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaValue.CamundaStringValue;
import io.holunda.command.api.value.CaseDefinitionId;
import io.holunda.command.api.value.CaseInstanceId;
import io.holunda.command.api.value.DeploymentId;
import io.holunda.command.api.value.ExecutionId;
import io.holunda.command.api.value.FormKey;
import io.holunda.command.api.value.GroupId;
import io.holunda.command.api.value.IncidentId;
import io.holunda.command.api.value.MessageName;
import io.holunda.command.api.value.ProcessDefinitionId;
import io.holunda.command.api.value.ProcessDefinitionKey;
import io.holunda.command.api.value.ProcessEngineName;
import io.holunda.command.api.value.ProcessInstanceId;
import io.holunda.command.api.value.TaskDefinitionKey;
import io.holunda.command.api.value.TaskId;
import io.holunda.command.api.value.TenantId;
import io.holunda.command.api.value.UserId;
import io.holunda.command.api.value.VersionTag;
import io.holunda.command.api.value.impl.ActivityIdValue;
import io.holunda.command.api.value.impl.ActivityInstanceIdValue;
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
import io.holunda.command.api.value.impl.TenantIdValue;
import io.holunda.command.api.value.impl.UserIdValue;
import io.holunda.command.api.value.impl.VersionTagValue;
import java.io.IOException;
import java.util.Map;
import java.util.function.Function;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class CamundaCommandModule extends SimpleModule {


  public static final String NAME = CamundaCommandModule.class.getSimpleName();
  private static final TypeReference<Map<String, Object>> MAP_REF = new TypeReference<Map<String, Object>>() {
  };

  public CamundaCommandModule() {
    super(NAME);

    registerValueType(ActivityId.class, ActivityIdValue::of);
    registerValueType(ActivityInstanceId.class, ActivityInstanceIdValue::of);
    registerValueType(BusinessKey.class, BusinessKeyValue::of);
    registerValueType(CaseDefinitionId.class, CaseDefinitionIdValue::of);
    registerValueType(CaseInstanceId.class, CaseInstanceIdValue::of);
    registerValueType(DeploymentId.class, DeploymentIdValue::of);
    registerValueType(ExecutionId.class, ExecutionIdValue::of);
    registerValueType(FormKey.class, FormKeyValue::of);
    registerValueType(GroupId.class, GroupIdValue::of);
    registerValueType(IncidentId.class, IncidentIdValue::of);
    registerValueType(MessageName.class, MessageNameValue::of);
    registerValueType(ProcessDefinitionId.class, ProcessDefinitionIdValue::of);
    registerValueType(ProcessDefinitionKey.class, ProcessDefinitionKeyValue::of);
    registerValueType(ProcessEngineName.class, ProcessEngineNameValue::of);
    registerValueType(ProcessInstanceId.class, ProcessInstanceIdValue::of);
    registerValueType(TaskDefinitionKey.class, TaskDefinitionKeyValue::of);
    registerValueType(TaskId.class, TaskIdValue::of);
    registerValueType(TenantId.class, TenantIdValue::of);
    registerValueType(UserId.class, UserIdValue::of);
    registerValueType(VersionTag.class, VersionTagValue::of);


    addDeserializer(VariableMap.class, new StdDeserializer<VariableMap>(VariableMap.class) {
      @Override
      public VariableMap deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Variables.fromMap(p.readValueAs(MAP_REF));
      }
    });

  }

  <T extends CamundaStringValue> void registerValueType(final Class<T> type, Function<String, T> factoryMethod) {

    addSerializer(type, new StdSerializer<T>(type) {
      @Override
      public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeString(value.getValue());
      }
    });

    addDeserializer(type, new StdDeserializer<T>(type) {
      @Override
      public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode treeNode = p.getCodec().readTree(p);
        String value = treeNode.asText();
        return factoryMethod.apply(value);
      }
    });

  }

}
