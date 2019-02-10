package tv.mechjack.testframework;

import java.util.concurrent.atomic.AtomicLong;

/**
 * The default implementation of `ArbitraryDataGenerator` used by
 * `TestFramework`. `DefaultArbitraryDataGenerator` uses an `AtomicLong` to
 * increment generated values.
 */
public final class DefaultArbitraryDataGenerator implements
    ArbitraryDataGenerator {

  private final AtomicLong atomicLong;

  /**
   * Constructs a new `DefaultArbitraryDataGenerator` that generates
   * incrementing values starting at `1`.
   */
  public DefaultArbitraryDataGenerator() {
    this(1L);
  }

  /**
   * Constructs a new `DefaultArbitraryDataGenerator` that generates
   * incrementing values starting at the value provided.
   *
   * @param initialValue the initial starting value
   */
  public DefaultArbitraryDataGenerator(final long initialValue) {
    this.atomicLong = new AtomicLong(initialValue);
  }

  @Override
  public final byte getByte() {
    return (byte) this.getLong();
  }

  @Override
  public final byte[] getByteArray() {
    return this.getString().getBytes();
  }

  @Override
  public final char getCharacter() {
    return (char) this.getLong();
  }

  @Override
  public final double getDouble() {
    return (double) this.getLong();
  }

  @Override
  public final float getFloat() {
    return (float) this.getLong();
  }

  @Override
  public final int getInteger() {
    return (int) this.getLong();
  }

  @Override
  public final long getLong() {
    return this.atomicLong.getAndIncrement();
  }

  @Override
  public final short getShort() {
    return (short) this.getLong();
  }

  @Override
  public final String getString() {
    return String.format("Arbitrary-%d", this.getLong());
  }

}
