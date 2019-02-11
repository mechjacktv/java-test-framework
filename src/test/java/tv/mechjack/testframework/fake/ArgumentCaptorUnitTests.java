package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;

import tv.mechjack.testframework.TestFramework;

public class ArgumentCaptorUnitTests {

  @Rule
  public final TestFramework testFramework = new TestFramework();

  @Test
  public final void apply_whenCalled_resultIsValueCaptured()
      throws Throwable {
    final String expected = this.testFramework.arbitraryData().getString();
    final InvocationContext context = new DefaultInvocationContext(
        null, null, new Object[] { expected });
    final ArgumentCaptor subjectUnderTest = new ArgumentCaptor(0);

    subjectUnderTest.apply(context);
    final String result = subjectUnderTest.getValue();

    assertThat(result).isEqualTo(expected);
  }

  @Test
  public final void apply_withChainingHandler_resultIsNextHandlerCalled()
      throws Throwable {
    final String expected = this.testFramework.arbitraryData().getString();
    final InvocationCounter invocationCounter = new InvocationCounter();
    final InvocationContext context = new DefaultInvocationContext(
        null, null, new Object[] { expected });
    final ArgumentCaptor subjectUnderTest = new ArgumentCaptor(0,
        invocationCounter);

    subjectUnderTest.apply(context);

    assertThat(invocationCounter.getCallCount()).isOne();
  }

}
