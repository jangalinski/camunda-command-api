package io.holunda.command.api.value;

import java.util.stream.Stream;

public enum TaskPriorityLabel {
  LOWEST(0,19, 0),
  LOW(20,39, 25),
  NORMAL(40,59, 50),
  HIGH(60,79, 75),
  HIGHEST(80,100, 100),
  ;

  private final int lower;
  private final int upper;
  private final int defaultValue;

  TaskPriorityLabel(int lower, int upper, int defaultValue) {
    this.lower = lower;
    this.upper = upper;
    this.defaultValue = defaultValue;
  }

  public static TaskPriorityLabel byPriority(int priority) {
    return Stream.of(values())
      .filter(it -> it.upper >= priority)
      .filter(it -> it.lower <= priority)
      .findFirst()
      .orElseThrow(() -> new IllegalArgumentException("priority:" + priority + " is not within bounds (0,100)"));
  }

  public int getDefaultValue() {
    return defaultValue;
  }

}
