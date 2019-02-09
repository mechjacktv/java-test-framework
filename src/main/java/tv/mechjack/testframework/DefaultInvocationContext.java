package tv.mechjack.testframework;

import java.lang.reflect.Method;

class DefaultInvocationContext implements InvocationContext {

  private final Object fake;
  private final Method method;
  private final Object[] arguments;

  public DefaultInvocationContext(final Object fake, final Method method,
      final Object[] arguments) {
    this.fake = fake;
    this.method = method;
    this.arguments = arguments;
  }

  @Override
  public Object[] getArguments() {
    return this.arguments;
  }

  @Override
  @SuppressWarnings("unchecked")
  public <T> T getArgument(final int index) {
    return (T) this.arguments[index];
  }

  @Override
  public Method getMethod() {
    return this.method;
  }

  @Override
  public Object getFake() {
    return this.fake;
  }

}
