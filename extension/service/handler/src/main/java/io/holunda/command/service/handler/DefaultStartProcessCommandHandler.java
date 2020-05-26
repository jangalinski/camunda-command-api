package io.holunda.command.service.handler;

import io.holunda.command.api.command.StartProcessByKeyCommand;
import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.command.api.handler.StartProcessByKeyCommandHandler;
import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CaseInstanceId;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstantiationBuilder;
import org.jetbrains.annotations.NotNull;

public class DefaultStartProcessCommandHandler implements StartProcessByKeyCommandHandler {

  private final RuntimeService runtimeService;

  public DefaultStartProcessCommandHandler(@NotNull final RuntimeService runtimeService) {
    this.runtimeService = runtimeService;
  }


  @Override
  public ProcessInstanceDto startProcess(@NotNull final StartProcessByKeyCommand cmd) {
    final ProcessInstantiationBuilder builder = runtimeService.createProcessInstanceByKey(cmd.getProcessDefinitionKey().getValue());

    builder.businessKey(cmd.getBusinessKey().map(BusinessKey::getValue).orElse(null));
    builder.caseInstanceId(cmd.getCaseInstanceId().map(CaseInstanceId::getValue).orElse(null));

    builder.setVariables(cmd.getVariables());

    return null;
  }
}
