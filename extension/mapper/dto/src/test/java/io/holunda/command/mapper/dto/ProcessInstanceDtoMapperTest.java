package io.holunda.command.mapper.dto;


import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.commons.immutables.ImmutableProcessInstance;
import org.junit.Test;

public class ProcessInstanceDtoMapperTest {

  @Test
  public void convert_camunda_class() {
    ImmutableProcessInstance im = ImmutableProcessInstance.builder()
      .id("1")
      .processDefinitionId("process")
      .build();

    ProcessInstanceDto dto = ProcessInstanceDtoMapper.INSTANCE.convert(im);

    assertThat(dto.getId().getValue()).isEqualTo("1");
  }
}
