package io.holunda.command.api.value;

//    /** indication of how important/urgent this task is with a number between
//     * 0 and 100 where higher values mean a higher priority and lower values mean
//     * lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high
//     * [80..100] highest */
//    int getPriority();

import java.util.stream.Stream;

public interface TaskPriority extends CamundaValues.CamundaIntValue{

  default TaskPriorityLabel getTaskPriorityLabel() {
    return TaskPriorityLabel.byPriority(getValue());
  }

  enum TaskPriorityLabel {
    LOWEST(0,19),
    LOW(20,39),
    NORMAL(40,59),
    HIGH(60,79),
    HIGHEST(80,100),
    ;

    private final int lower;
    private final int upper;

    TaskPriorityLabel(int lower, int upper) {
      this.lower = lower;
      this.upper = upper;
    }

    public static TaskPriorityLabel byPriority(int priority) {
      return Stream.of(values())
        .filter(it -> it.upper >= priority)
        .filter(it -> it.lower <= priority)
        .findFirst()
        .orElseThrow(() -> new IllegalArgumentException("priority:" + priority + " is not within bounds (0,100)"));
    }
  }
}
