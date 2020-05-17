package io.holunda.command.api.value.impl;

import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;
import org.jetbrains.annotations.NotNull;

final class ValueImplGenerator {

  @Value.Style(
    // Detect names starting with underscore
    typeAbstract = "_*",
    // Generate without any suffix, just raw detected name
    typeImmutable = "*Value",
    // Make generated public, leave underscored as package private
    visibility = ImplementationVisibility.PUBLIC,
    // Seems unnecessary to have builder or superfluous copy method
    defaults = @Value.Immutable(builder = false, copy = false))
  @interface WrappedValue {
    // empty annotation
  }

  static abstract class StringValueWrapper {

    @Value.Parameter
    @NotNull
    public abstract String getValue();

    @Value.Check
    protected void check() {
      if (getValue() == null || "".equals(getValue().trim())) {
        throw new IllegalArgumentException("string value must not be null or empty");
      }
    }

    @Override
    public String toString() {
      return getClass().getSimpleName().replace("Value", "")+ "(" + getValue() + ")";
    }
  }



  private ValueImplGenerator() {
    // util class
  }
}
