package tv.mechjack.testframework;

import java.lang.reflect.Method;

/**
 * Method invocation context passed to `MethodInvocationHandler` instances.
 */
public interface InvocationContext {

  /**
   * Returns an array of arguments passed to the method when it was invoked.
   *
   * @return an array of arguments
   */
  Object[] getArguments();

  /**
   * Returns the argument at the specified index.
   *
   * @param index the argument index
   * @param <T> the argument type
   * @return the argument
   */
  <T> T getArgument(int index);

  /**
   * Returns the method invoked.
   *
   * @return the method invoked
   */
  Method getMethod();

  /**
   * Returns the fake instance the method was invoked on.
   *
   * @return the fake instance
   */
  Object getFake();

}
