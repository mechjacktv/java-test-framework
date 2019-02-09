package tv.mechjack.testframework;

public class InvocationCounter extends ChainingMethodInvocationHandler {

  private int callCount;

  public InvocationCounter() {
    this(null);
  }

  public InvocationCounter(final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.callCount = 0;
  }

  @Override
  protected boolean execute(final InvocationContext invocationContext) {
    this.callCount++;
    return true;
  }

  public final int getCallCount() {
    return this.callCount;
  }

}
