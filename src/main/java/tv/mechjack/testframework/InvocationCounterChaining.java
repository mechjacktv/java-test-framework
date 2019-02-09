package tv.mechjack.testframework;

public class InvocationCounterChaining extends ChainingMethodInvocationHandler {

  private int callCount;

  public InvocationCounterChaining() {
    this(null);
  }

  public InvocationCounterChaining(final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.callCount = 0;
  }

  @Override
  protected boolean execute(final Invocation invocation) {
    this.callCount++;
    return true;
  }

  public final int getCallCount() {
    return this.callCount;
  }

}
