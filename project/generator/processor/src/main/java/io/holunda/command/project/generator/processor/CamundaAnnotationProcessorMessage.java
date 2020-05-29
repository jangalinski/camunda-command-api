package io.holunda.command.project.generator.processor;

import io.toolisticon.annotationprocessortoolkit.tools.corematcher.ValidationMessage;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public enum CamundaAnnotationProcessorMessage implements ValidationMessage {

  ERROR_COULD_NOT_CREATE_VALUE_MAPPER("CAMUNDA_COMMAND_ERROR_001", "Couldn't create CamundaValueMapper : ${0}");

  /**
   * Flag that defines if messages codes will be written as part of the message.
   */
  private static final boolean printMessageCodes = false;

  /**
   * the message code.
   */
  private final String code;

  /**
   * the message text.
   */
  private final String message;

}
