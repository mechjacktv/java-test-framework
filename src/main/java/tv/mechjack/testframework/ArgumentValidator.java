package tv.mechjack.testframework;

import java.util.function.Function;

public class ArgumentValidator extends ChainingMethodInvocationHandler {

  private final Function<Invocation, Boolean> validator;
  private boolean valid;

  public ArgumentValidator(final Function<Invocation, Boolean> validator) {
    this(validator, null);
  }

  public ArgumentValidator(final Function<Invocation, Boolean> validator,
      final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.validator = validator;
    this.valid = false;
  }

  @Override
  protected boolean execute(final Invocation invocation) {
    this.valid = this.validator.apply(invocation);
    return this.valid;
  }

  public final boolean isValid() {
    return this.valid;
  }

}
