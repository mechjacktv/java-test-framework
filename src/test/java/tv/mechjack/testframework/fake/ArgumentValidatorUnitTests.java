package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ArgumentValidatorUnitTests {

  @Test
  public final void apply_withValidArguments_resultIsIsValueIsTrue()
      throws Throwable {
    final InvocationContext context = new DefaultInvocationContext(
        null, null, new Object[] {});
    final ArgumentValidator subjectUnderTest = new ArgumentValidator(
        invocationContext -> true);

    subjectUnderTest.apply(context);

    assertThat(subjectUnderTest.isValid()).isTrue();
  }

  @Test
  public final void apply_withValidArguments_resultIsNextHandlerCalled()
      throws Throwable {
    final InvocationContext context = new DefaultInvocationContext(
        null, null, new Object[] {});
    final InvocationCounter invocationCounter = new InvocationCounter();
    final ArgumentValidator subjectUnderTest = new ArgumentValidator(
        invocationContext -> true, invocationCounter);

    subjectUnderTest.apply(context);

    assertThat(invocationCounter.getCallCount()).isOne();
  }

  @Test
  public final void apply_withInvalidArguments_resultIsNextHandlerNotCalled()
      throws Throwable {
    final InvocationContext context = new DefaultInvocationContext(
        null, null, new Object[] {});
    final InvocationCounter invocationCounter = new InvocationCounter();
    final ArgumentValidator subjectUnderTest = new ArgumentValidator(
        invocationContext -> false, invocationCounter);

    subjectUnderTest.apply(context);

    assertThat(invocationCounter.getCallCount()).isZero();
  }

}
