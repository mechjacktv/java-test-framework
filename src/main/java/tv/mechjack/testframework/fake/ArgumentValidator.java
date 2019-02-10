package tv.mechjack.testframework.fake;

import java.util.function.Function;

/**
 * A `MethodInvocationHandler` that validates the arguments passed to the
 * method invocation. The validator has the option to short-circuit passing
 * the call on to the next `MethodInvocationHandler`.
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
 *     final boolean[] valid = new boolean[1];
 *     final ArgumentValidator argumentValidator = new ArgumentValidator(
 *         invocation -> {
 *           valid[0] = Objects.nonNull(invocation.getArgument(0));
 *           return true;
 *         });
 *     final FakeBuilder<MyInterface> fakeBuilder = this.testFramework
 *         .fakeBuilder(MyInterface.class);
 *
 *     fakeBuilder.forMethod("getValue", new Class[] { String.class })
 *         .setHandler(argumentValidator);
 *
 *     final MyService subjectUnderTest = new MyService(fakeBuilder.build());
 *
 *     final Object result = subjectUnderTest.doSomething();
 *
 *     Assertions.assertThat(valid).isTrue();
 *   }
 *
 * }
 * ``` */
public final class ArgumentValidator extends ChainingMethodInvocationHandler {

  private final Function<InvocationContext, Boolean> validator;
  private boolean valid;

  /**
   * Constructs a new `ArgumentValidator` which passes the method invocation to
   * the specified validator and only passes on to the next
   * `MethodInvocationHandler` if, and only if, the validator returns `true`.
   *
   * @param validator the validation function
   */
  public ArgumentValidator(
      final Function<InvocationContext, Boolean> validator) {
    this(validator, null);
  }

  public ArgumentValidator(final Function<InvocationContext, Boolean> validator,
      final MethodInvocationHandler invocationHandler) {
    super(invocationHandler);
    this.validator = validator;
    this.valid = false;
  }

  @Override
  protected final boolean execute(final InvocationContext invocationContext) {
    this.valid = this.validator.apply(invocationContext);
    return this.valid;
  }

  public final boolean isValid() {
    return this.valid;
  }

}
