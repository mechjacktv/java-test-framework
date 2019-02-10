package tv.mechjack.testframework;

import java.lang.reflect.InvocationHandler;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provider;

import org.junit.rules.ExternalResource;

import tv.mechjack.testframework.fake.FakeBuilder;
import tv.mechjack.testframework.fake.FakeFactory;

public final class TestFramework extends ExternalResource {

  public static final int ARBITRARY_COLLECTION_SIZE = 20;

  private final Supplier<Module> frameworkModuleSupplier;
  private final Set<Module> registeredModules = new HashSet<>();
  private Injector injector;

  public TestFramework() {
    this(Optional.empty());
  }

  public TestFramework(final Supplier<Module> frameworkModuleSupplier) {
    this(Optional.of(frameworkModuleSupplier));
  }

  private TestFramework(
      final Optional<Supplier<Module>> frameworkModuleSupplier) {
    this.frameworkModuleSupplier = frameworkModuleSupplier
        .orElse(DefaultTestFrameworkModule::new);
    this.injector = null;
  }

  @Override
  protected final void before() {
    this.registeredModules.clear();
    this.registerModule(this.frameworkModuleSupplier.get());
  }

  @Override
  protected final void after() {
    this.injector = null;
  }

  public final void registerModule(final Module module) {
    this.registeredModules.add(module);
  }

  public final <T> T getInstance(final Class<T> type) {
    return this.getInjector().getInstance(type);
  }

  private Injector getInjector() {
    if (this.injector == null) {
      this.injector = Guice.createInjector(this.registeredModules);
    }
    return this.injector;
  }

  public final void currentTimeDelta(final long delta, final TimeUnit unit) {
    this.currentTimeDelta(delta, unit, 0);
  }

  public final void currentTimeDelta(final long delta, final TimeUnit unit,
      final long shift) {
    this.getInstance(TestClock.class).currentTimeDelta(unit.toMillis(delta) + shift);
  }

  public final <T> T fake(Class<T> type) {
    return this.getInstance(FakeFactory.class).fake(type);
  }

  public final <T> T fake(Class<T> type, InvocationHandler handler) {
    return this.getInstance(FakeFactory.class).fake(type, handler);
  }

  public final <T> FakeBuilder<T> fakeBuilder(Class<T> type) {
    return this.getInstance(FakeFactory.class).builder(type);
  }

  public final byte getArbitraryByte() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getByte();
  }

  public final byte[] getArbitraryByteArray() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getByteArray();
  }

  public final char getArbitraryCharacter() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getCharacter();
  }

  public final double getArbitraryDouble() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getDouble();
  }

  public final float getArbitraryFloat() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getFloat();
  }

  public final int getArbitraryInteger() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getInteger();
  }

  public final long getArbitraryLong() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getLong();
  }

  public final short getArbitraryShort() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getShort();
  }

  public final String getArbitraryString() {
    return this.getInstance(DefaultArbitraryDataGenerator.class).getString();
  }

  public final <T> T getInstance(final Key<T> type) {
    return this.getInjector().getInstance(type);
  }

  public final <T> Provider<T> getProvider(final Class<T> type) {
    return this.getInjector().getProvider(type);
  }

  public final <T> Provider<T> getProvider(final Key<T> type) {
    return this.getInjector().getProvider(type);
  }

  public final void nextRandomValue(final Long nextValue) {
    this.getInstance(TestRandom.class).setNextValue(nextValue);
  }

}
