package io.holunda.command.api.camunda;

import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.runtime.ProcessInstanceWithVariables;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.immutables.value.Value;
import org.springframework.lang.Nullable;

enum RuntimePojos {
  ;

  @Value.Immutable
  @CamundaPojoStyle
  interface _ProcessInstance extends ProcessInstanceWithVariables {

    @Override
    @Nullable
    String getBusinessKey();

    @Override
    @Nullable
    String getCaseInstanceId();

    @Override
    @Nullable
    String getTenantId();

    @Override
    @Value.Default
    default VariableMap getVariables() {
      return Variables.createVariables();
    }
  }
}
