package tv.mechjack.testframework.fake;

import java.lang.reflect.Method;

/**
 * An API for creating fake interface implementations with fine grained method
 * invocation handling. You can use this API to register handlers for the
 * methods called during the course of the test. Any method call without a
 * handler is no-op and will return `null`.
 *
 * @param <T> The interface type
 */
public interface FakeBuilder<T> {

  /**
   * Returns a `MethodInvocationBuilder` which is used to register a
   * `MethodInvocationHandler` for the method that matches the signature
   * provided.
   *
   * @param methodName     the method name
   * @param parameterTypes the method parameter types
   * @return a `MethodInvocationBuilder` used to register a
   * `MethodInvocationHandler`
   */
  MethodInvocationBuilder<T> forMethod(String methodName,
      Class<?>... parameterTypes);

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
