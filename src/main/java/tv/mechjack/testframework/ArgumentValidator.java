package tv.mechjack.testframework;

import java.util.function.Function;

/**
 * Validates the arguments passed to the method invocation. The validator has
 * the option to short-circuit passing the call on to the next
 * `MethodInvocationHandler`.
 */
public final class ArgumentValidator extends ChainingMethodInvocationHandler {

  private final Function<InvocationContext, Boolean> validator;
  private boolean valid;

  /**
   * Constructs a new `ArgumentValidator` which passes the method invocation to
   * the specified validator and only passes on to the next
   * `MethodInvocationHandler` if, and only if, the validator returns `true`.
   *
   * @param validator the validation function
   */
  public ArgumentValidator(
      final Function<InvocationContext, Boolean> validator) {
    this(validator, null);
  }

  public ArgumentValidator(final Function<InvocationContext, Boolean> validator,
      final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.validator = validator;
    this.valid = false;
  }

  @Override
  protected final boolean execute(final InvocationContext invocationContext) {
    this.valid = this.validator.apply(invocationContext);
    return this.valid;
  }

  public final boolean isValid() {
    return this.valid;
  }

}
