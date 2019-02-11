package tv.mechjack.testframework;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import tv.mechjack.testframework.fake.DefaultFakeFactory;
import tv.mechjack.testframework.fake.FakeFactory;

public class DefaultTestFrameworkModuleUnitTests {

  @Test
  public final void configure_whenCalled_resultIsDefaultArbitraryDataBound() {
    final Injector injector = Guice.createInjector(new DefaultTestFrameworkModule());

    final ArbitraryData result = injector.getInstance(ArbitraryData.class);

    Assertions.assertThat(result).isInstanceOf(DefaultArbitraryData.class);
  }

  @Test
  public final void configure_whenCalled_resultIsDefaultFakeFactoryBound() {
    final Injector injector = Guice.createInjector(new DefaultTestFrameworkModule());

    final FakeFactory result = injector.getInstance(FakeFactory.class);

    Assertions.assertThat(result).isInstanceOf(DefaultFakeFactory.class);
  }

  @Test
  public final void configure_whenCalled_resultIsDefaultTestClockBound() {
    final Injector injector = Guice.createInjector(new DefaultTestFrameworkModule());

    final TestClock result = injector.getInstance(TestClock.class);

    Assertions.assertThat(result).isInstanceOf(DefaultTestClock.class);
  }

  @Test
  public final void configure_whenCalled_resultIsDefaultTestRandomBound() {
    final Injector injector = Guice.createInjector(new DefaultTestFrameworkModule());

    final TestRandom result = injector.getInstance(TestRandom.class);

    Assertions.assertThat(result).isInstanceOf(DefaultTestRandom.class);
  }

}
