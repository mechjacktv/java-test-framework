package tv.mechjack.testframework;

/**
 * Counts the number of times a method was invoked.
 */
public final class InvocationCounter extends ChainingMethodInvocationHandler {

  private int callCount;

  /**
   * Constructs a new `InvocationCounter` which counts the number of times a
   * method was invoked.
   */
  public InvocationCounter() {
    this(null);
  }

  /**
   * Constructs a new `InvocationCounter` which counts the number of times a
   * method was invoked passing the method invocation on to the next
   * `MethodInvocationHandler` in the chain.
   *
   * @param invocationHandler the next `MethodInvocationHandler` in the chain
   */
  public InvocationCounter(final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.callCount = 0;
  }

  /**
   * Implements the behavior of this `MethodInvocationHandler`.
   *
   * @param invocationContext the method invocationContext context
   * @return a boolean specifying weather to continue to the next
   * `MethodInvocationHandler`, always returns `true`
   */
  @Override
  protected final boolean execute(final InvocationContext invocationContext) {
    this.callCount++;
    return true;
  }

  /**
   * Returns the number of times the method was invoked.
   *
   * @return the number of times the method was invoked
   */
  public final int getCallCount() {
    return this.callCount;
  }

}
