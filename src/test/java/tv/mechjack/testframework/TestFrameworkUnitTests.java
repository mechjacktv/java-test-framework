package tv.mechjack.testframework;

import static org.assertj.core.api.Assertions.assertThat;

import com.google.inject.Binder;
import com.google.inject.Module;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import tv.mechjack.testframework.fake.DefaultFakeBuilder;
import tv.mechjack.testframework.fake.DefaultFakeFactory;
import tv.mechjack.testframework.fake.FakeBuilder;
import tv.mechjack.testframework.fake.FakeFactory;
import tv.mechjack.testframework.fake.InvocationCounter;
import tv.mechjack.testframework.fake.MethodInvocationHandler;

public final class TestFrameworkUnitTests {

  @Test
  public final void before_defaultModule_resultIsDefaultImplementations() {
    final TestFramework subjectUnderTest = new TestFramework();

    subjectUnderTest.before();

    final SoftAssertions softly = new SoftAssertions();

    softly.assertThat(subjectUnderTest.arbitraryData())
        .isInstanceOf(DefaultArbitraryData.class);
    softly.assertThat(subjectUnderTest.fakeBuilder(Runnable.class))
        .isInstanceOf(DefaultFakeBuilder.class);
    softly.assertThat(subjectUnderTest.fakeFactory())
        .isInstanceOf(DefaultFakeFactory.class);
    softly.assertThat(subjectUnderTest.testClock())
        .isInstanceOf(DefaultTestClock.class);
    softly.assertThat(subjectUnderTest.testRandom())
        .isInstanceOf(DefaultTestRandom.class);
    softly.assertAll();
  }

  public final void before_customModule_resultIsCustomModuleIsUsed() {
    final InvocationCounter invocationCounter = new InvocationCounter();
    final Module fakeModule = this.givenACountingModule(invocationCounter);
    final TestFramework subjectUnderTest = new TestFramework(() -> fakeModule);

    subjectUnderTest.before();

    assertThat(invocationCounter.getCallCount()).isOne();
  }

  public final void before_subsequentCall_resultIsNewModuleCreated() {
    final InvocationCounter invocationCounter = new InvocationCounter();
    final Module fakeModule = this.givenACountingModule(invocationCounter);
    final TestFramework subjectUnderTest = new TestFramework(() -> fakeModule);

    subjectUnderTest.before();
    subjectUnderTest.after();
    subjectUnderTest.before();

    assertThat(invocationCounter.getCallCount()).isEqualTo(2);
  }

  public final void registerModule_injectorIsUsed_resultIsRegisteredModuleIsInstalled() {
    final InvocationCounter invocationCounter = new InvocationCounter();
    final Module fakeModule = this.givenACountingModule(invocationCounter);
    final TestFramework subjectUnderTest = new TestFramework();
    subjectUnderTest.before();

    subjectUnderTest.registerModule(fakeModule);

    subjectUnderTest.arbitraryData();
    assertThat(invocationCounter.getCallCount()).isOne();
  }

  private Module givenACountingModule(final MethodInvocationHandler handler) {
    final FakeFactory fakeFactory = new DefaultFakeFactory();
    final FakeBuilder<Module> fakeBuilder = fakeFactory.builder(Module.class);

    fakeBuilder.forMethod("configure", new Class[] { Binder.class })
        .setHandler(handler);
    return fakeBuilder.build();
  }

}
