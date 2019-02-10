package tv.mechjack.testframework.fake;

import java.lang.reflect.InvocationHandler;

/**
 * An API for creating fake interface implementations used for testing.
 *
 * This class is available to be injected via Guice or through the
 * `TestFramework`.
 */
public interface FakeFactory {

  /**
   * Returns a builder for creating fake interface implementations used for
   * testing.
   *
   * @param type the interface class to fake
   * @param <T> The interface type
   * @return an instance of `FakeBuilder`
   */
  <T> FakeBuilder<T> builder(Class<T> type);

  /**
   * Returns a simple fake that returns null for all method calls.
   *
   * @param type the interface `Class` to fake
   * @param <T> The interface type
   * @return a fake implementation of the specified interface
   */
  <T> T fake(Class<T> type);

  /**
   * Returns a fake that forwards method invocations to the `InvocationHandler`
   * provided.
   *
   * @param type the interface `Class` to fake
   * @param handler the method `InvocationHandler`
   * @param <T> The interface type
   * @return a fake implementation of the specified interface
   */
  <T> T fake(Class<T> type, InvocationHandler handler);

}
