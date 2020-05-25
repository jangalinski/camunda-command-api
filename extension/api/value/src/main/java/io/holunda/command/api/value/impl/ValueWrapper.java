package io.holunda.command.api.value.impl;

import org.immutables.value.Value;

abstract class ValueWrapper<T> {

  static abstract class NonEmptyStringValueWrapper extends ValueWrapper<String> {

    @Value.Check
    protected void check() {
      if (getValue() == null || "".equals(getValue().trim())) {
        throw new IllegalArgumentException("string value must not be null or empty");
      }
    }

    @Override
    public String toString() {
      return super.toString();
    }
  }

  static abstract class LongValueWrapper extends ValueWrapper<Long> {
    @Override
    public String toString() {
      return super.toString();
    }
  }

  static abstract class IntValueWrapper extends ValueWrapper<Integer> {

    @Override
    public String toString() {
      return super.toString();
    }
  }

  @Value.Parameter
  public abstract T getValue();

  @Override
  public String toString() {
    return getClass().getSimpleName().replace("Value", "")+ "(" + getValue() + ")";
  }

}
