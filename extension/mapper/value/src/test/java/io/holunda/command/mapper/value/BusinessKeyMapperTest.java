package io.holunda.command.mapper.value;

import static org.assertj.core.api.Assertions.assertThat;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaValues;
import org.junit.Test;

public class BusinessKeyMapperTest {

  @Test
  public void convert() {
    BusinessKey businessKey = CamundaValues.businessKey("12345");

    assertThat(BusinessKeyMapper.INSTANCE.fromValue(businessKey)).isEqualTo("12345");
    assertThat(BusinessKeyMapper.INSTANCE.toValue("12345")).isEqualTo(businessKey);
  }
}
