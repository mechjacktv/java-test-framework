package tv.mechjack.testframework;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;

import org.junit.rules.ExternalResource;

import tv.mechjack.testframework.fake.FakeBuilder;
import tv.mechjack.testframework.fake.FakeFactory;

/**
 * JUnit 4 `TestRule` which implements the test framework, acts as an
 * entrance point for framework implementations and provides a number of
 * convenience methods.
 *
 * ## Example Use
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 * }
 * ```
 */
public final class TestFramework extends ExternalResource {

  private final Supplier<Module> moduleSupplier;
  private final Set<Module> registeredModules;
  private Injector injector;

  /**
   * Constructs a new `TestFramework` which uses default implementations of
   * framework classes.
   */
  public TestFramework() {
    this(Optional.empty());
  }

  /**
   * Constructs a new `TestFramework` using the Guice `Module` provided to
   * create framework classes. The provided module may optionally bind
   * additional classes used during testing. A new instance of the provided
   * module is created for each test executed.
   *
   * @param supplier supplies the Guice `Module` to create framework classes
   */
  public TestFramework(final Supplier<Module> supplier) {
    this(Optional.of(supplier));
  }

  private TestFramework(final Optional<Supplier<Module>> supplier) {
    this.moduleSupplier = supplier.orElse(DefaultTestFrameworkModule::new);
    this.registeredModules = new HashSet<>();
    this.injector = null;
  }

  /**
   * Returns the instance of `ArbitraryData` used during test execution.
   *
   * @return the `ArbitraryData` in use
   */
  public final ArbitraryData arbitraryData() {
    return this.getInstance(ArbitraryData.class);
  }

  /**
   * Instantiates a `FakeBuilder` for the specified type which can be used to
   * register `MethodInvocationHandler` instances for desired methods.
   *
   * @param type the interface `Class` to fake
   * @param <T> The interface type
   * @return a `FakeBuilder` for the specified interface
   */
  public final <T> FakeBuilder<T> fakeBuilder(final Class<T> type) {
    return this.getInstance(FakeFactory.class).builder(type);
  }

  /**
   * Returns the instance of `FakeFactory` used during test execution.
   *
   * @return the `FakeFactory` in use
   */
  public final FakeFactory fakeFactory() {
    return this.getInstance(FakeFactory.class);
  }

  /**
   * Uses Guice to create an instance of the specified `Class`.
   *
   * @param type the `Class` for the desired type
   * @param <T> the desired type
   * @return the created instance
   */
  public final <T> T getInstance(final Class<T> type) {
    return this.getInjector().getInstance(type);
  }

  /**
   * Uses Guice to create an instance of the specified `Key`.
   *
   * @param type the `Key` for the desired type
   * @param <T> the desired type
   * @return the created instance
   */
  public final <T> T getInstance(final Key<T> type) {
    return this.getInjector().getInstance(type);
  }

  /**
   * Returns a Guice `Provider` for the specified `Class`.
   *
   * @param type the `Class` for the desired type
   * @param <T> the desired type
   * @return the instance `Provider`
   */
  public final <T> Provider<T> getProvider(final Class<T> type) {
    return this.getInjector().getProvider(type);
  }

  /**
   * Returns a Guice `Provider` for the specified `Key`.
   *
   * @param type the `Key` for the desired type
   * @param <T> the desired type
   * @return the instance `Provider`
   */
  public final <T> Provider<T> getProvider(final Key<T> type) {
    return this.getInjector().getProvider(type);
  }

  /**
   * Registers an additional Guice `Module` used during test execution. All
   * calls to `registerModule` made after the first time a class or
   * class `Provider` registered with Guice is created will be ignored.
   * It's best practice to register all `Module`s needed before any other test
   * code is executed.
   *
   * @param module the Guice `Module`
   */
  public final void registerModule(final Module module) {
    this.registeredModules.add(module);
  }

  /**
   * Returns the instance of `TestClock` used during test execution.
   *
   * @return the `TestClock` in use
   */
  public final TestClock testClock() {
    return this.getInstance(TestClock.class);
  }

  /**
   * Returns the instance of `TestRandom` used during test execution.
   *
   * @return the `TestRandom` in use
   */
  public final TestRandom testRandom() {
    return this.getInstance(TestRandom.class);
  }

  /**
   * Called before every test execution. Clears any previously registered
   * modules and creates a new instance of the framework `Module`.
   */
  @Override
  protected final void before() {
    this.registeredModules.clear();
    this.registerModule(this.moduleSupplier.get());
  }

  /**
   * Called after every test execution. Nullifies the Guice injector created
   * for a test execution.
   */
  @Override
  protected final void after() {
    this.injector = null;
  }

  private Injector getInjector() {
    if (this.injector == null) {
      this.injector = Guice.createInjector(this.registeredModules);
    }
    return this.injector;
  }

}
