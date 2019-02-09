package tv.mechjack.testframework;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

class DefaultFakeBuilder<T> implements FakeBuilder<T> {

  private final FakeFactory fakeFactory;
  private final Class<T> type;
  private final Map<Method, MethodInvocationHandler> methodHandlers;

  DefaultFakeBuilder(final FakeFactory fakeFactory, final Class<T> type) {
    this.fakeFactory = fakeFactory;
    this.type = type;
    this.methodHandlers = new HashMap<>();
  }

  @Override
  public MethodInvocationBuilder<T> forMethod(final String methodName, final Class<?>... parameterTypes) {
    try {
      return this.forMethod(type.getMethod(methodName, parameterTypes));
    } catch (NoSuchMethodException e) {
      throw new FakeInstantiationException(e);
    }
  }

  @Override
  public MethodInvocationBuilder<T> forMethod(final Method method) {
    return new DefaultMethodInvocationBuilder<>(this, method);
  }

  private FakeBuilder<T> addMethodHandler(final Method method, final MethodInvocationHandler methodHandler) {
    this.methodHandlers.put(method, methodHandler);
    return this;
  }

  @Override
  public T build() {
    final InstanceInvocationHandler instanceInvocationHandler = new InstanceInvocationHandler();

    for (final Method method : this.methodHandlers.keySet()) {
      instanceInvocationHandler.addHandler(method, this.methodHandlers.get(method));
    }
    return this.fakeFactory.fake(this.type, instanceInvocationHandler);
  }

  private static final class DefaultMethodInvocationBuilder<T> implements MethodInvocationBuilder<T> {

    private final DefaultFakeBuilder<T> fakeBuilder;
    private final Method method;

    DefaultMethodInvocationBuilder(final DefaultFakeBuilder<T> fakeBuilder, final Method method) {
      this.fakeBuilder = fakeBuilder;
      this.method = method;
    }

    @Override
    public FakeBuilder<T> setMethodInvocationHandler(final MethodInvocationHandler handler) {
      return this.fakeBuilder.addMethodHandler(this.method, handler);
    }

  }

}
