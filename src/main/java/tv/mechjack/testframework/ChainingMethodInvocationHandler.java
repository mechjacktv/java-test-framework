package tv.mechjack.testframework;

import java.util.Objects;

abstract class ChainingMethodInvocationHandler implements MethodInvocationHandler {

  private final MethodInvocationHandler nextHandler;

  public ChainingMethodInvocationHandler() {
    this(null);
  }

  public ChainingMethodInvocationHandler(final MethodInvocationHandler nextHandler) {
    this.nextHandler = nextHandler;
  }

  @Override
  public final Object apply(final Invocation invocation) throws Throwable {
    final boolean callNext = execute(invocation);

    if (callNext && Objects.nonNull(this.nextHandler)) {
      return this.nextHandler.apply(invocation);
    }
    return null;
  }

  protected abstract boolean execute(final Invocation invocation) throws Throwable;

}
