package io.holunda.command.test;

import java.util.ArrayList;
import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.engine.impl.cfg.StandaloneInMemProcessEngineConfiguration;
import org.camunda.bpm.engine.test.ProcessEngineRule;
import org.camunda.bpm.engine.test.mock.MockExpressionManager;
import org.mockito.Mock;

public class TestProcessEngine {

  public static ProcessEngineConfigurationImpl processEngineConfiguration() {
    return new StandaloneInMemProcessEngineConfiguration() {{
      setExpressionManager(new MockExpressionManager());
      setHistory(HISTORY_FULL);
      setJobExecutorActivate(false);
      setMetricsEnabled(false);
      this.databaseSchemaUpdate = DB_SCHEMA_UPDATE_TRUE;
      this.jobExecutorActivate = false;
      this.setCustomPostBPMNParseListeners(new ArrayList<>());
      this.setCustomJobHandlers(new ArrayList<>());
    }};
  }

  public static ProcessEngineRule processEngineRule() {
    return new ProcessEngineRule(processEngineConfiguration().buildProcessEngine());
  }

}
