package tv.mechjack.testframework.fake;

/**
 * A `MethodInvocationHandler` that captures the argument at the specified
 * index.
 *
 * ## Example Use
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 *  {@literal @}Test
 *   public final void testSomeServiceMethod() {
 *     final ArgumentCaptor argumentCaptor = new ArgumentCaptor(0);
 *     final FakeBuilder<MyInterface> fakeBuilder = this.testFramework
 *         .fakeBuilder(MyInterface.class);
 *
 *     fakeBuilder.forMethod("getValue", new Class[] { String.class })
 *         .setHandler(argumentCaptor);
 *
 *     final MyService subjectUnderTest = new MyService(fakeBuilder.build());
 *
 *     final Object result = subjectUnderTest.doSomething();
 *
 *     Assertions.assertThat(argumentCaptor.getValue()).isNotNull();
 *   }
 *
 * }
 * ```
 */
public final class ArgumentCaptor extends ChainingMethodInvocationHandler {

  private final int index;
  private Object value;

  /**
   * Constructs a new `ArgumentCaptor` which captures the argument at the
   * specified index.
   *
   * @param index the argument index
   */
  public ArgumentCaptor(final int index) {
    this(index, null);
  }

  /**
   * Constructs a new `ArgumentCaptor` which captures the argument at the
   * specified index before forwarding the method invocation to the
   * `MethodInvocationHandler` provided.
   *
   * @param index the argument index
   * @param nextHandler the next `MethodInvocationHandler` called
   */
  public ArgumentCaptor(final int index,
      final MethodInvocationHandler nextHandler) {
    super(nextHandler);
    this.index = index;
    this.value = null;
  }

  /**
   * Implements the behavior of this `MethodInvocationHandler`.
   *
   * @param invocationContext the method invocationContext context
   * @return a boolean specifying weather to continue to the next
   * `MethodInvocationHandler`, always returns `true`
   */
  @Override
  protected final boolean execute(final InvocationContext invocationContext) {
    this.value = invocationContext.getArgument(this.index);
    return true;
  }

  /**
   * Returns the value captured.
   *
   * @return the value captured
   */
  @SuppressWarnings("unchecked")
  public final <T> T getValue() {
    return (T) this.value;
  }

}
