package io.holunda.command.project.generator.api.immutables;

import org.immutables.serial.Serial;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

@Value.Style(
  // Detect names starting with underscore
  typeAbstract = "_*",
  // Generate without any suffix, just raw detected name
  typeImmutable = "*",
  // Make generated public, leave underscored as package private
  visibility = ImplementationVisibility.PUBLIC,
  // Seems unnecessary to have builder or superfluous copy method
  defaults = @Value.Immutable(builder = true, copy = true)
)
@Serial.Version(1L)
public @interface ImmutableCamundaDto {
  // empty annotation
}
