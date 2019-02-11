package tv.mechjack.testframework.fake;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import tv.mechjack.testframework.TestClock;

public class DefaultFakeFactoryUnitTests {

  @Test
  public final void builder_whenCalled_resultIsNonNull() {
    final DefaultFakeFactory subjectUnderTest = new DefaultFakeFactory();

    final FakeBuilder<TestClock> result = subjectUnderTest.builder(TestClock.class);

    assertThat(result).isNotNull();
  }

  @Test
  public final void fake_whenCalled_resultIsNonNull() {
    final DefaultFakeFactory subjectUnderTest = new DefaultFakeFactory();

    final TestClock result = subjectUnderTest.fake(TestClock.class);

    assertThat(result).isNotNull();
  }

}
