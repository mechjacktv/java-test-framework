package tv.mechjack.testframework;

import java.util.concurrent.atomic.AtomicLong;

public final class ArbitraryDataGenerator {

  private final AtomicLong atomicLong;

  ArbitraryDataGenerator() {
    this.atomicLong = new AtomicLong(1);
  }

  public final byte getByte() {
    return (byte) this.getLong();
  }

  public final byte[] getByteArray() {
    return this.getString().getBytes();
  }

  public final char getCharacter() {
    return (char) this.getLong();
  }

  public final double getDouble() {
    return (double) this.getLong();
  }

  public final float getFloat() {
    return (float) this.getLong();
  }

  public final int getInteger() {
    return (int) this.getLong();
  }

  public final long getLong() {
    return this.atomicLong.getAndIncrement();
  }

  public final short getShort() {
    return (short) this.getLong();
  }

  public final String getString() {
    return String.format("Arbitrary-%d", this.getLong());
  }

}
