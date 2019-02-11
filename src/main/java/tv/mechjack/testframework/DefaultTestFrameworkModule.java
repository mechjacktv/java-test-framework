package tv.mechjack.testframework;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import tv.mechjack.testframework.fake.DefaultFakeFactory;
import tv.mechjack.testframework.fake.FakeFactory;

/**
 * The default `Module` used by `TestFramework`. This module registers the
 * default implementations for `ArbitraryData`, `FakeFactory`,
 * `TestClock` and `TestRandom`.
 */
public final class DefaultTestFrameworkModule extends AbstractModule {

  @Override
  protected final void configure() {
    this.bind(ArbitraryData.class)
        .to(DefaultArbitraryData.class)
        .in(Scopes.SINGLETON);

    this.bind(FakeFactory.class)
        .to(DefaultFakeFactory.class)
        .in(Scopes.SINGLETON);

    this.bind(TestClock.class)
        .to(DefaultTestClock.class)
        .in(Scopes.SINGLETON);

    this.bind(TestRandom.class)
        .to(DefaultTestRandom.class)
        .in(Scopes.SINGLETON);
  }

}
