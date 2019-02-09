package tv.mechjack.testframework;

/**
 * Supplied by an instance of `FakeBuilder` to set a `MethodInvocationHandler`
 * for a method on the fake to be created.
 *
 * @param <T> The interface type
 */
public interface MethodInvocationBuilder<T> {

  /**
   * Sets the `MethodInvocationHandler` for a method on the fake to be created.
   *
   * @param handler the `MethodInvocationHandler`
   * @return the `FakeBuilder` that supplied this `MethodInvocationBuilder`
   */
  FakeBuilder<T> setHandler(MethodInvocationHandler handler);

}
