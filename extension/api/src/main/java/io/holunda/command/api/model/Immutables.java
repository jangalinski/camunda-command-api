package io.holunda.command.api.model;

import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

public enum Immutables {
  ;

  @Value.Style(
    // Detect names starting with underscore
    typeAbstract = "_*",
    // Generate without any suffix, just raw detected name
    typeImmutable = "*",
    // Make generated public, leave underscored as package private
    visibility = ImplementationVisibility.PUBLIC,
    // Seems unnecessary to have builder or superfluous copy method
    defaults = @Value.Immutable(builder = true, copy = true))
  public @interface ImmutableObject {
    // empty annotation
  }


  @Value.Style(
    // Detect names starting with underscore
    typeAbstract = "_*",
    // Generate without any suffix, just raw detected name
    typeImmutable = "*",
    // Make generated public, leave underscored as package private
    visibility = ImplementationVisibility.PUBLIC,
    // Seems unnecessary to have builder or superfluous copy method
    defaults = @Value.Immutable(builder = false, copy = false))
  @interface Wrapped {
    // empty annotation
  }

  // base wrapper type
  static abstract class Wrapper<T> {

    @Value.Parameter
    public abstract T value();

    @Override
    public String toString() {
      return getClass().getSimpleName() + "(" + value() + ")";
    }
  }

  static abstract class StringWrapper extends Wrapper<String> {

    @Value.Check
    protected void check() {
      if (value() == null || "".equals(value().trim())) {
        throw new IllegalArgumentException("string value must not be null or empty");
      }
    }
  }
}
