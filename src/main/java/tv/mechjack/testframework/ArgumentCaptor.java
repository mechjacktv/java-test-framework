package tv.mechjack.testframework;

/**
 * Captures the argument at the specified index.
 */
public final class ArgumentCaptor extends ChainingMethodInvocationHandler {

  private final int index;
  private Object value;

  /**
   * Constructs a new `ArgumentCaptor` which captures the argument at the
   * specified index.
   *
   * @param index the argument index
   */
  public ArgumentCaptor(final int index) {
    this(index, null);
  }

  /**
   * Constructs a new `ArgumentCaptor` which captures the argument at the
   * specified index. The method invocation will be forwarded to the next
   * `MethodInvocationHandler` provided.
   *
   * @param index the argument index
   * @param nextHandler the next `MethodInvocationHandler` called
   */
  public ArgumentCaptor(final int index, final MethodInvocationHandler nextHandler) {
    super(nextHandler);
    this.index = index;
    this.value = null;
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
    this.value = invocationContext.getArgument(this.index);
    return true;
  }

  /**
   * Returns the value captured.
   *
   * @return the value captured
   */
  @SuppressWarnings("unchecked")
  public final <T> T getValue() {
    return (T) this.value;
  }

}
