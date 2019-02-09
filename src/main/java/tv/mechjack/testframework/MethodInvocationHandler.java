package tv.mechjack.testframework;

public interface MethodInvocationHandler {

  Object apply(InvocationContext invocationContext) throws Throwable;

}
