package io.holunda.command.api.handler;

import io.holunda.command.api.command.StartProcessByKeyCommand;
import io.holunda.command.api.dto.ProcessInstanceDto;

public interface StartProcessByKeyCommandHandler {

  ProcessInstanceDto startProcess(StartProcessByKeyCommand cmd);
}
