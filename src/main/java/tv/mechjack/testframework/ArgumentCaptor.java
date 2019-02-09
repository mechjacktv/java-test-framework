package tv.mechjack.testframework;

public class ArgumentCaptor extends ChainingMethodInvocationHandler {

  private final int index;
  private Object value;

  public ArgumentCaptor(final int index) {
    this(index, null);
  }

  public ArgumentCaptor(final int index, final MethodInvocationHandler nextHandler) {
    super(nextHandler);
    this.index = index;
    this.value = null;
  }

  @Override
  protected boolean execute(final Invocation invocation) throws Throwable {
    this.value = invocation.getArgument(this.index);
    return true;
  }

  @SuppressWarnings("unchecked")
  public final <T> T getValue() {
    return (T) this.value;
  }

}
