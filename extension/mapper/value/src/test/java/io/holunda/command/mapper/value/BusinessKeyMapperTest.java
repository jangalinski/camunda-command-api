package io.holunda.command.mapper.value;

import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaValues;
import org.junit.Test;

public class BusinessKeyMapperTest {

  @Test
  public void convert() {
    BusinessKey businessKey = CamundaValues.businessKey("12345");

    assertThat(BusinessKeyMapper.INSTANCE.convert(businessKey)).isEqualTo("12345");
    assertThat(BusinessKeyMapper.INSTANCE.convert("12345")).isEqualTo(businessKey);
  }
}
