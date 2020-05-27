package io.holunda.command.mapper.dto;


import static io.holunda.command.api.value.CamundaValues.DEFAULT_PROCESS_ENGINE_NAME;
import static io.holunda.command.api.value.CamundaValues.businessKey;
import static io.holunda.command.api.value.CamundaValues.caseInstanceId;
import static io.holunda.command.api.value.CamundaValues.processDefinitionId;
import static io.holunda.command.api.value.CamundaValues.processInstanceId;
import static io.holunda.command.api.value.CamundaValues.tenantId;
import static io.holunda.command.mapper.dto._Fixtures.BUSINESS_KEY;
import static io.holunda.command.mapper.dto._Fixtures.PROCESS_DEFINITION_ID;
import static io.holunda.command.mapper.dto._Fixtures.PROCESS_INSTANCE_ID;
import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.api.dto.ProcessInstanceDto;
import io.holunda.commons.immutables.ImmutableProcessInstance;
import org.junit.Test;

public class ProcessInstanceDtoMapperTest {

  private ImmutableProcessInstance im = ImmutableProcessInstance.builder()
    .id(PROCESS_INSTANCE_ID)
    .processDefinitionId(PROCESS_DEFINITION_ID)
    .build();

  private ProcessInstanceDto dto = ProcessInstanceDto.builder()
    .id(processInstanceId(PROCESS_INSTANCE_ID))
    .processDefinitionId(processDefinitionId(PROCESS_DEFINITION_ID))
    .build();

  @Test
  public void convert_camunda_class() {
    assertThat(ProcessInstanceDtoMapper.INSTANCE.convert(im)).isEqualTo(dto);


    im = im.withBusinessKey(BUSINESS_KEY);
    dto = dto.withBusinessKey(businessKey(BUSINESS_KEY));
    assertThat(ProcessInstanceDtoMapper.INSTANCE.convert(im)).isEqualTo(dto);

    im = im.withCaseInstanceId("1");
    dto = dto.withCaseInstanceId(caseInstanceId("1"));
    assertThat(ProcessInstanceDtoMapper.INSTANCE.convert(im)).isEqualTo(dto);

    im = im.withTenantId("tenant");
    dto = dto.withTenantId(tenantId("tenant"));
    assertThat(ProcessInstanceDtoMapper.INSTANCE.convert(im)).isEqualTo(dto);

    assertThat(dto.getVariables()).isEmpty();
    assertThat(dto.getProcessEngineName()).isEqualTo(DEFAULT_PROCESS_ENGINE_NAME);
  }

  @Test
  public void convert_dto() {
    assertThat(ProcessInstanceDtoMapper.INSTANCE.convert(im)).isEqualTo(dto);
  }
}
