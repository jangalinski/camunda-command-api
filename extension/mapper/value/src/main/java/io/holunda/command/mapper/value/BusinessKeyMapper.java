package io.holunda.command.mapper.value;

import io.holunda.command.api.value.BusinessKey;
import io.holunda.command.api.value.impl.BusinessKeyValue;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BusinessKeyMapper {

  BusinessKeyMapper INSTANCE = Mappers.getMapper(BusinessKeyMapper.class);

  default BusinessKey toValue(String string) {
    return BusinessKeyValue.of(string);
  }

  default String fromValue(BusinessKey value) {
    return value.getValue();
  }

}
