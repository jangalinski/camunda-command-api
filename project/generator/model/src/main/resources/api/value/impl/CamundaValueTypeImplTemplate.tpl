package ${ packageName };

import io.holunda.command.api.value.${ typeSimpleName };
import io.holunda.command.api.value.impl.ValueWrapper.${ valueWrapperTypeSimpleName };
import io.holunda.command.project.generator.api.immutables.WrappedValue;
import org.immutables.value.Value;

@Value.Immutable
@WrappedValue
abstract class _${ typeSimpleName } extends ${ valueWrapperTypeSimpleName } implements ${ typeSimpleName } {
  // empty generator template
}
