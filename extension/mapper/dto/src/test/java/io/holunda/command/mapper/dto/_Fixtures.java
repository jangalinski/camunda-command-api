package io.holunda.command.mapper.dto;

import java.util.UUID;

public enum _Fixtures {
  ;

  static String uuid() {
    return UUID.randomUUID().toString();
  }

  public static final String PROCESS_INSTANCE_ID = uuid();
  public static final String PROCESS_DEFINITION_ID = uuid();
  public static final String BUSINESS_KEY = uuid();
}
