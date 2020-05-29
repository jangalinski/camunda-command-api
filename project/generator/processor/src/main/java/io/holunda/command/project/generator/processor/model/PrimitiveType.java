package io.holunda.command.project.generator.processor.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public enum PrimitiveType {
  STRING(String.class),
  LONG(Long.class),
  INTEGER(Integer.class),
  ;

  @Getter
  private final Class<?> type;

  @Getter(lazy = true)
  private final String typeSimpleName = getType().getSimpleName();
}
