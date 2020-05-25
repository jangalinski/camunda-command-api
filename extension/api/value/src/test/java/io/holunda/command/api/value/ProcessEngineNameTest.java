package io.holunda.command.api.value;

import static io.holunda.command.api.value.CamundaValues.DEFAULT_PROCESS_ENGINE_NAME;
import static io.holunda.command.api.value.CamundaValues.processEngineName;
import static org.assertj.core.api.Assertions.assertThat;

import org.camunda.bpm.engine.ProcessEngines;
import org.junit.Test;

public class ProcessEngineNameTest {

  @Test
  public void create() {
    assertThat(processEngineName("engine").getValue()).isEqualTo("engine");
  }

  @Test
  public void default_value() {
    assertThat(DEFAULT_PROCESS_ENGINE_NAME.getValue()).isEqualTo(ProcessEngines.NAME_DEFAULT);
  }
}
