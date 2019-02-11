package tv.mechjack.testframework.fake;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * The default implementation of `FakeBuilder` used by `TestFramework`.
 */
public class DefaultFakeBuilder<T> implements FakeBuilder<T> {

  private final FakeFactory fakeFactory;
  private final Class<T> type;
  private final Map<Method, MethodInvocationHandler> methodHandlers;

  @Inject
  public DefaultFakeBuilder(final FakeFactory fakeFactory,
      final Class<T> type) {
    this.fakeFactory = fakeFactory;
    this.type = type;
    this.methodHandlers = new HashMap<>();
  }

  @Override
  public MethodInvocationBuilder<T> forMethod(final String methodName) {
    return this.forMethod(methodName, new Class[] {});
  }

  @Override
  public MethodInvocationBuilder<T> forMethod(final String methodName,
      final Class<?>... parameterTypes) {
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

  @Override
  public T build() {
    final RoutingInvocationHandler routingInvocationHandler = new RoutingInvocationHandler();

    for (final Method method : this.methodHandlers.keySet()) {
      routingInvocationHandler
          .addHandler(method, this.methodHandlers.get(method));
    }
    return this.fakeFactory.fake(this.type, routingInvocationHandler);
  }

  private FakeBuilder<T> addMethodHandler(final Method method,
      final MethodInvocationHandler methodHandler) {
    this.methodHandlers.put(method, methodHandler);
    return this;
  }

  private static final class DefaultMethodInvocationBuilder<T>
      implements MethodInvocationBuilder<T> {

    private final DefaultFakeBuilder<T> fakeBuilder;
    private final Method method;

    DefaultMethodInvocationBuilder(final DefaultFakeBuilder<T> fakeBuilder,
        final Method method) {
      this.fakeBuilder = fakeBuilder;
      this.method = method;
    }

    @Override
    public FakeBuilder<T> setHandler(
        final MethodInvocationHandler handler) {
      return this.fakeBuilder.addMethodHandler(this.method, handler);
    }

  }

}
