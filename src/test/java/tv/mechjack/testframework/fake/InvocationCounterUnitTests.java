package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class InvocationCounterUnitTests {

  @Test
  public final void apply_whenCalled_resultIsOneInvocationCounted()
      throws Throwable {
    final InvocationCounter subjectUnderTest = new InvocationCounter();

    subjectUnderTest.apply(this.givenAnInvocationContext());
    final int result = subjectUnderTest.getCallCount();

    assertThat(result).isOne();
  }

  @Test
  public final void apply_whenCalledTwice_resultIsTwoInvocationCounted()
      throws Throwable {
    final InvocationCounter subjectUnderTest = new InvocationCounter();

    subjectUnderTest.apply(this.givenAnInvocationContext());
    subjectUnderTest.apply(this.givenAnInvocationContext());
    final int result = subjectUnderTest.getCallCount();

    assertThat(result).isEqualTo(2);
  }

  private InvocationContext givenAnInvocationContext() {
    return new DefaultInvocationContext(
        null, null, new Object[] {});
  }

}
