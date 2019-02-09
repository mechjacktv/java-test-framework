package tv.mechjack.testframework;

public interface MethodHandlerBuilder<T> {

  FakeBuilder<T> addHandler(MethodInvocationHandler handler);

}
