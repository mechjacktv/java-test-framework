package tv.mechjack.testframework;

interface MethodHandlerBuilder<T> {

  FakeBuilder<T> addHandler(MethodInvocationHandler handler);

}
