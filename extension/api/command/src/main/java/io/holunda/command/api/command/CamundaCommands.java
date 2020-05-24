package io.holunda.command.api.command;

import io.holunda.command.api.value.facet.WithProcessEngineName;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

public  final class CamundaCommands {

  public interface CamundaCommand extends WithProcessEngineName {

  }

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
    public @interface ImmutableCamundaCommand {
      // empty annotation
    }
  }

  private CamundaCommands() {
    // do not instantiate
  }
}
