package tv.mechjack.testframework;

import java.util.concurrent.atomic.AtomicLong;

/**
 * A source of test data when the specific value doesn't matter. The
 * `ArbitraryDataGenerator` will generate values for your tests that are unique.
 * <p>
 * This class is available to be injected via Guice or through the
 * `TestFrameworkRule`.
 */
public final class ArbitraryDataGenerator {

  private final AtomicLong atomicLong;

  ArbitraryDataGenerator() {
    this.atomicLong = new AtomicLong(1);
  }

  /**
   * Returns an arbitrary `byte` value.
   *
   * @return an arbitrary `byte` value
   */
  public final byte getByte() {
    return (byte) this.getLong();
  }

  /**
   * Returns an arbitrary `long` value.
   *
   * @return an arbitrary `long` value
   */
  public final long getLong() {
    return this.atomicLong.getAndIncrement();
  }

  /**
   * Returns an arbitrary `byte[]` value.
   *
   * @return an arbitrary `byte[]` value
   */
  public final byte[] getByteArray() {
    return this.getString().getBytes();
  }

  /**
   * Returns an arbitrary `String` value.
   *
   * @return an arbitrary `String` valueå
   */
  public final String getString() {
    return String.format("Arbitrary-%d", this.getLong());
  }

  /**
   * Returns an arbitrary `char` value.
   *
   * @return an arbitrary `char` value
   */
  public final char getCharacter() {
    return (char) this.getLong();
  }

  /**
   * Returns an arbitrary `double` value.
   *
   * @return an arbitrary `double` value
   */
  public final double getDouble() {
    return (double) this.getLong();
  }

  /**
   * Returns an arbitrary `float` value.
   *
   * @return an arbitrary `float` value
   */
  public final float getFloat() {
    return (float) this.getLong();
  }

  /**
   * Returns an arbitrary `int` value.
   *
   * @return an arbitrary `int` value
   */
  public final int getInteger() {
    return (int) this.getLong();
  }

  /**
   * Returns an arbitrary `short` value.
   *
   * @return an arbitrary `short` value
   */
  public final short getShort() {
    return (short) this.getLong();
  }

}
