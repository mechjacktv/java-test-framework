package tv.mechjack.testframework.fake;

import java.util.Objects;

/**
 * Base class that can be extended to chain `MethodInvocationHandler`s together.
 */
public abstract class ChainingMethodInvocationHandler
    implements MethodInvocationHandler {

  private final MethodInvocationHandler nextHandler;

  /**
   * Constructs a new `ChainingMethodInvocationHandler` which can optionally
   * forward the method invocation to the `MethodInvocationHandler` provided
   * if not `null`.
   *
   * @param nextHandler the next `MethodInvocationHandler` in the chain
   */
  public ChainingMethodInvocationHandler(
      final MethodInvocationHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  /**
   * Provides the logic to call `execute(InvocationContext)` and forward to the
   * next `MethodInvocationHandler` if desired.
   *
   * @param invocationContext the method invocation context
   * @return an optional return value supplied by the next
   * `MethodInvocationHandler` or `null` if not provided
   * @throws Throwable throws if `execute(InvocationContext)` or the next
   * `MethodInvocationHandler` throws an exception
   */
  @Override
  public final Object apply(final InvocationContext invocationContext)
      throws Throwable {
    final boolean callNext = execute(invocationContext);

    if (callNext && Objects.nonNull(this.nextHandler)) {
      return this.nextHandler.apply(invocationContext);
    }
    return null;
  }

  /**
   * Called before the method invocation is forwarded to the next
   * `MethodInvocationHandler` in the chain. The method invocation will be
   * forwarded if, and only if, this method returns `true`.
   *
   * @param invocationContext the method invocation context
   * @return a `boolean` indicating if the method invocation should be forwarded
   * @throws Throwable the implementation may optionally throw an exception
   */
  protected abstract boolean execute(final InvocationContext invocationContext)
      throws Throwable;

}
