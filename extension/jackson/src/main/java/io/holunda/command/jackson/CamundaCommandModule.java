package io.holunda.command.jackson;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.deser.std.StdKeyDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
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
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;

public class CamundaCommandModule extends SimpleModule {

  public static final String NAME = CamundaCommandModule.class.getSimpleName();
  private static final TypeReference<Map<String, Object>> MAP_REF = new TypeReference<Map<String, Object>>() {
  };

  public CamundaCommandModule() {
    super(NAME);

    Stream.of(
      BusinessKey.class,
      CaseInstanceId.class,
      DeploymentId.class,
      MessageName.class,
      ProcessDefinitionId.class,
      ProcessDefinitionKey.class,
      ProcessInstanceId.class,
      TaskId.class,
      TenantId.class
    ).forEach(this::registerValueType);

    addDeserializer(VariableMap.class, new StdDeserializer<VariableMap>(VariableMap.class) {
      @Override
      public VariableMap deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        return Variables.fromMap(p.readValueAs(MAP_REF));
      }
    });
  }

  <T extends CamundaStringValue> void registerValueType(final Class<T> type) {
    final String name = type.getSimpleName();
    final String valueName = name + "Value";
    final String key = Character.toLowerCase(name.charAt(0)) + name.substring(1);

    try {
      Class<?> valueClass = Class.forName(type.getPackage().getName() + ".impl." + valueName);
      Method factory = valueClass.getMethod("of", String.class);

      addSerializer(type, new StdSerializer<T>(type) {
        @Override
        public void serialize(T value, JsonGenerator gen, SerializerProvider provider) throws IOException {
          gen.writeString(value.getValue());
        }
      });
      addDeserializer(type, new StdDeserializer<T>(type) {
        @Override
        @SuppressWarnings("unchecked")
        public T deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
          JsonNode treeNode = p.getCodec().readTree(p);
          String value = treeNode.asText();
          try {
            return (T) factory.invoke(null, value);
          } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
          }
        }
      });
    } catch (ClassNotFoundException | NoSuchMethodException e) {
      throw new RuntimeException(e);
    }
  }

}
