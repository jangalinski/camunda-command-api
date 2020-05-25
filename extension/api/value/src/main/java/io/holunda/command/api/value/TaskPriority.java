package io.holunda.command.api.value;

//    /** indication of how important/urgent this task is with a number between
//     * 0 and 100 where higher values mean a higher priority and lower values mean
//     * lower priority: [0..19] lowest, [20..39] low, [40..59] normal, [60..79] high
//     * [80..100] highest */
//    int getPriority();

public interface TaskPriority extends CamundaValues.CamundaIntValue{

  default TaskPriorityLabel getTaskPriorityLabel() {
    return TaskPriorityLabel.byPriority(getValue());
  }

}
