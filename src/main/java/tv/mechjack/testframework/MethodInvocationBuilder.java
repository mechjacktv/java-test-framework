package tv.mechjack.testframework;

public interface MethodInvocationBuilder<T> {

  FakeBuilder<T> addHandler(MethodInvocationHandler handler);

}
