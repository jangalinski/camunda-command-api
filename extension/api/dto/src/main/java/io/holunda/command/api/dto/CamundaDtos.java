package io.holunda.command.api.dto;

import io.holunda.command.api.value.facet.WithProcessEngineName;
import org.immutables.value.Value;
import org.immutables.value.Value.Style.ImplementationVisibility;

public final class CamundaDtos {

  public interface CamundaDto extends WithProcessEngineName {

  }

  private CamundaDtos() {
    // empty, do not instantiate
  }
}
