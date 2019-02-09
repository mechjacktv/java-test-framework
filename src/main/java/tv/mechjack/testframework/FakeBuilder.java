package tv.mechjack.testframework;

import java.lang.reflect.Method;

/**
 * A builder for creating fake interface implementations used for testing. You
 * can use this API to register handlers for the methods called during the
 * course of the test.
 *
 * @param <T> The interface type
 */
public interface FakeBuilder<T> {

  /**
   * Returns a `MethodInvocationBuilder` which is used to register a
   * `MethodInvocationHandler` for the method that matches the signature provided.
   *
   * @param methodName the method name
   * @param parameterTypes the method parameter types
   * @return a `MethodInvocationBuilder` used to register a
   * `MethodInvocationHandler`
   */
  MethodInvocationBuilder<T> forMethod(String methodName, Class<?>... parameterTypes);

  /**
   * Returns a `MethodInvocationBuilder` which is used to register a
   * `MethodInvocationHandler` for the `Method` provided.
   *
   * @param method the method
   * @return a `MethodInvocationBuilder` used to register a
   * `MethodInvocationHandler`
   */
  MethodInvocationBuilder<T> forMethod(Method method);

  /**
   * Builds and returns the fake interface implementation.
   *
   * @return the fake interface implementation
   */
  T build();

}
