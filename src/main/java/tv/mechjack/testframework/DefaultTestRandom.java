package tv.mechjack.testframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * The default implementation of `TestRandom` used by `TestFramework`.
 */
public final class DefaultTestRandom implements TestRandom {

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
  public Boolean nextBoolean() {
    if (this.nextBooleanIndex.get() >= this.nextBooleans.size()) {
      throw new IllegalStateException(
          String.format("Boolean for index '%d' was not set.",
              this.nextBooleanIndex.get()));
    }
    return this.nextBooleans.get(this.nextBooleanIndex.getAndIncrement());
  }

  @Override
  public Byte nextByte() {
    if (this.nextByteIndex.get() >= this.nextBytes.size()) {
      throw new IllegalStateException(
          String.format("Byte for index '%d' was not set.",
              this.nextByteIndex.get()));
    }
    return this.nextBytes.get(this.nextByteIndex.getAndIncrement());
  }

  @Override
  public byte[] nextByteArray() {
    if (this.nextByteArrayIndex.get() >= this.nextByteArrays.size()) {
      throw new IllegalStateException(
          String.format("ByteArray for index '%d' was not set.",
              this.nextByteArrayIndex.get()));
    }
    return this.nextByteArrays.get(this.nextByteArrayIndex.getAndIncrement());
  }

  @Override
  public Double nextDouble() {
    if (this.nextDoubleIndex.get() >= this.nextDoubles.size()) {
      throw new IllegalStateException(
          String.format("Double for index '%d' was not set.",
              this.nextDoubleIndex.get()));
    }
    return this.nextDoubles.get(this.nextDoubleIndex.getAndIncrement());
  }

  @Override
  public Float nextFloat() {
    if (this.nextFloatIndex.get() >= this.nextFloats.size()) {
      throw new IllegalStateException(
          String.format("Float for index '%d' was not set.",
              this.nextFloatIndex.get()));
    }
    return this.nextFloats.get(this.nextFloatIndex.getAndIncrement());
  }

  @Override
  public Integer nextInteger() {
    if (this.nextIntegerIndex.get() >= this.nextIntegers.size()) {
      throw new IllegalStateException(
          String.format("Integer for index '%d' was not set.",
              this.nextIntegerIndex.get()));
    }
    return this.nextIntegers.get(this.nextIntegerIndex.getAndIncrement());
  }

  @Override
  public Long nextLong() {
    if (this.nextLongIndex.get() >= this.nextLongs.size()) {
      throw new IllegalStateException(
          String.format("Long for index '%d' was not set.",
              this.nextLongIndex.get()));
    }
    return this.nextLongs.get(this.nextLongIndex.getAndIncrement());
  }

  @Override
  public void setNextValues(final Boolean... values) {
    this.nextBooleans.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final Byte... values) {
    this.nextBytes.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final byte[]... values) {
    this.nextByteArrays.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final Double... values) {
    this.nextDoubles.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final Float... values) {
    this.nextFloats.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final Integer... values) {
    this.nextIntegers.addAll(Arrays.asList(values));
  }

  @Override
  public void setNextValues(final Long... values) {
    this.nextLongs.addAll(Arrays.asList(values));
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
