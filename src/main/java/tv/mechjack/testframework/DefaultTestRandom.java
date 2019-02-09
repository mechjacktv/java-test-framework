package tv.mechjack.testframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

final class DefaultTestRandom implements TestRandom {

  private AtomicInteger nextBooleanIndex = new AtomicInteger(0);
  private List<Boolean> nextBooleans = new ArrayList<>();
  private AtomicInteger nextByteIndex = new AtomicInteger(0);
  private List<Byte> nextBytes = new ArrayList<>();
  private AtomicInteger nextByteArrayIndex = new AtomicInteger(0);
  private List<byte[]> nextByteArrays = new ArrayList<>();
  private AtomicInteger nextDoubleIndex = new AtomicInteger(0);
  private List<Double> nextDoubles = new ArrayList<>();
  private AtomicInteger nextFloatIndex = new AtomicInteger(0);
  private List<Float> nextFloats = new ArrayList<>();
  private AtomicInteger nextIntegerIndex = new AtomicInteger(0);
  private List<Integer> nextIntegers = new ArrayList<>();
  private AtomicInteger nextLongIndex = new AtomicInteger(0);
  private List<Long> nextLongs = new ArrayList<>();

  @Override
  public boolean nextBoolean() {
    if (nextBooleanIndex.get() >= nextBooleans.size()) {
      throw new IllegalStateException(
          String.format("Boolean for index '%d' was not set.",
              nextBooleanIndex.get()));
    }
    return nextBooleans.get(nextBooleanIndex.getAndIncrement());
  }

  @Override
  public byte nextByte() {
    if (nextByteIndex.get() >= nextBytes.size()) {
      throw new IllegalStateException(
          String.format("Byte for index '%d' was not set.",
              nextByteIndex.get()));
    }
    return nextBytes.get(nextByteIndex.getAndIncrement());
  }

  @Override
  public byte[] nextByteArray() {
    if (nextByteArrayIndex.get() >= nextByteArrays.size()) {
      throw new IllegalStateException(
          String.format("ByteArray for index '%d' was not set.",
              nextByteArrayIndex.get()));
    }
    return nextByteArrays.get(nextByteArrayIndex.getAndIncrement());
  }

  @Override
  public double nextDouble() {
    if (nextDoubleIndex.get() >= nextDoubles.size()) {
      throw new IllegalStateException(
          String.format("Double for index '%d' was not set.",
              nextDoubleIndex.get()));
    }
    return nextDoubles.get(nextDoubleIndex.getAndIncrement());
  }

  @Override
  public float nextFloat() {
    if (nextFloatIndex.get() >= nextFloats.size()) {
      throw new IllegalStateException(
          String.format("Float for index '%d' was not set.",
              nextFloatIndex.get()));
    }
    return nextFloats.get(nextFloatIndex.getAndIncrement());
  }

  @Override
  public int nextInteger() {
    if (nextIntegerIndex.get() >= nextIntegers.size()) {
      throw new IllegalStateException(
          String.format("Integer for index '%d' was not set.",
              nextIntegerIndex.get()));
    }
    return nextIntegers.get(nextIntegerIndex.getAndIncrement());
  }

  @Override
  public long nextLong() {
    if (nextLongIndex.get() >= nextLongs.size()) {
      throw new IllegalStateException(
          String.format("Long for index '%d' was not set.",
              nextLongIndex.get()));
    }
    return nextLongs.get(nextLongIndex.getAndIncrement());
  }

  @Override
  public void setNextValue(final boolean value, final boolean... values) {
    nextBooleans.add(value);
    for (final boolean next : values) {
      nextBooleans.add(next);
    }
  }

  @Override
  public void setNextValue(final byte value, final byte... values) {
    nextBytes.add(value);
    for (final byte next : values) {
      nextBytes.add(next);
    }
  }

  @Override
  public void setNextValue(final byte[] value, final byte[]... values) {
    nextByteArrays.add(value);
    nextByteArrays.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValue(final double value, final double... values) {
    nextDoubles.add(value);
    for (final double next : values) {
      nextDoubles.add(next);
    }
  }

  @Override
  public void setNextValue(final float value, final float... values) {
    nextFloats.add(value);
    for (final float next : values) {
      nextFloats.add(next);
    }
  }

  @Override
  public void setNextValue(final int value, final int... values) {
    nextIntegers.add(value);
    for (final int next : values) {
      nextIntegers.add(next);
    }
  }

  @Override
  public void setNextValue(final long value, final long... values) {
    nextLongs.add(value);
    for (final long next : values) {
      nextLongs.add(next);
    }
  }

  @Override
  public void reset() {
    this.nextBooleanIndex.set(0);
    this.nextBooleans.clear();
    this.nextByteIndex.set(0);
    this.nextBytes.clear();
    this.nextByteArrayIndex.set(0);
    this.nextByteArrays.clear();
    this.nextDoubleIndex.set(0);
    this.nextDoubles.clear();
    this.nextFloatIndex.set(0);
    this.nextFloats.clear();
    this.nextIntegerIndex.set(0);
    this.nextIntegers.clear();
    this.nextLongIndex.set(0);
    this.nextLongs.clear();
  }

}
