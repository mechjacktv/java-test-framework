package tv.mechjack.testframework;

/**
 * Callback interface for handling method invocations on fakes used during
 * testing.
 */
public interface MethodInvocationHandler {

  /**
   * Called when the method this `MethodInvocationHandler` is attached to is
   * invoked.
   *
   * @param invocationContext the method invocation context
   * @return the optional return value for the invoked method
   * @throws Throwable thrown if the implementation throws an `Exception`
   */
  Object apply(InvocationContext invocationContext) throws Throwable;

}
