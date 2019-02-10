package tv.mechjack.testframework;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

import tv.mechjack.testframework.fake.DefaultFakeBuilder;
import tv.mechjack.testframework.fake.DefaultFakeFactory;
import tv.mechjack.testframework.fake.FakeBuilder;
import tv.mechjack.testframework.fake.FakeFactory;

/**
 * The default `Module` used by `TestFramework`. This module registers the
 * default implementations for `ArbitraryDataGenerator`, `FakeBuilder`,
 * `FakeFactory`, `TestClock` and `TestRandom`.
 */
public final class DefaultTestFrameworkModule extends AbstractModule {

  @Override
  protected final void configure() {
    this.bind(ArbitraryDataGenerator.class)
        .to(DefaultArbitraryDataGenerator.class)
        .in(Scopes.SINGLETON);

    this.bind(FakeBuilder.class)
        .to(DefaultFakeBuilder.class);

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
