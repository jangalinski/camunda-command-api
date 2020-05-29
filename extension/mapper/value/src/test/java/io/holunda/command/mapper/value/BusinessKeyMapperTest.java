package io.holunda.command.mapper.value;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.CamundaValues;
import org.junit.Test;

public class BusinessKeyMapperTest {

  @Test
  public void convert() {
    BusinessKey businessKey = CamundaValues.businessKey("12345");

//    FIXME assertThat(BusinessKeyMapper.INSTANCE.convert(businessKey)).isEqualTo("12345");
//    assertThat(BusinessKeyMapper.INSTANCE.convert("12345")).isEqualTo(businessKey);
  }
}
