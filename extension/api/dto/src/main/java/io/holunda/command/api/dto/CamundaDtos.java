package io.holunda.command.api.dto;

import io.holunda.command.api.value.facet.WithProcessEngineName;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

public final class CamundaDtos {


  public static final class Immutables {

    @Value.Style(
      // Detect names starting with underscore
      typeAbstract = "_*",
      // Generate without any suffix, just raw detected name
      typeImmutable = "*",
      // Make generated public, leave underscored as package private
      visibility = ImplementationVisibility.PUBLIC,
      // Seems unnecessary to have builder or superfluous copy method
      defaults = @Value.Immutable(builder = true, copy = true))
    public @interface ImmutableCamundaDto {
      // empty annotation
    }
  }

  public interface CamundaDto extends WithProcessEngineName {

  }

  private CamundaDtos() {
    // empty, do not instantiate
  }
}
