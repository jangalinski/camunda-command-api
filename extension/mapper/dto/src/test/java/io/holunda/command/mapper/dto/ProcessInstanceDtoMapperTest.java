package io.holunda.command.mapper.dto;


import io.holunda.commons.immutables.ImmutableProcessInstance;
import org.junit.Test;

public class ProcessInstanceDtoMapperTest {

  @Test
  public void convert_camunda_class() {
    ImmutableProcessInstance.builder()
      .id("1")
      .processDefinitionId("process")
      .build();
  }
}
