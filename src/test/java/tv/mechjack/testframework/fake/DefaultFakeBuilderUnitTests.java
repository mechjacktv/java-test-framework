package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.Rule;
import org.junit.Test;

import tv.mechjack.testframework.TestClock;
import tv.mechjack.testframework.TestFramework;

public class DefaultFakeBuilderUnitTests {

  @Rule
  public final TestFramework testFramework = new TestFramework();

  @Test
  public final void forMethodSetHandler_methodExists_resultIsHandlerIsExecuted() {
    final InvocationCounter handler = new InvocationCounter();
    final DefaultFakeBuilder<TestClock> subjectUnderTest = new DefaultFakeBuilder<>(this.testFramework.fakeFactory(),
        TestClock.class);

    subjectUnderTest.forMethod("currentTime").setHandler(handler);
    final TestClock fakeTestClock = subjectUnderTest.build();
    fakeTestClock.currentTime();

    assertThat(handler.getCallCount()).isOne();
  }

  @Test
  public final void forMethodSetHandler_methodDoesNotExists_resultIsFakeInstantiationException() {
    final DefaultFakeBuilder<TestClock> subjectUnderTest = new DefaultFakeBuilder<>(this.testFramework.fakeFactory(),
        TestClock.class);

    final Throwable thrown = catchThrowable(() -> subjectUnderTest.forMethod(
        "doneNotExist"));

    assertThat(thrown).isInstanceOf(FakeInstantiationException.class);
  }

}
