package tv.mechjack.testframework;

public interface MethodInvocationHandler {

  Object apply(Invocation invocation) throws Throwable;

}
