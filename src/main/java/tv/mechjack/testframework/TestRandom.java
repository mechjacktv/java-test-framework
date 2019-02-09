package tv.mechjack.testframework;

/**
 * A non-random source of "random" values used during unit testing. Real random
 * values and unit tests don't mix. Implementations that require random values
 * should abstract their access behind an interface that can be faked during
 * testing. A test implementation can wrap an implementation of this interface,
 * which will automatically be reset if the test class is using the instance
 * supplied by the `TestFramework`.
 */
public interface TestRandom {

  /**
   * Returns the next supplied `boolean` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `boolean` value
   * @throws IllegalStateException if no next value has been supplied
   */
  boolean nextBoolean();

  /**
   * Returns the next supplied `byte` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `byte` value
   * @throws IllegalStateException if no next value has been supplied
   */
  byte nextByte();

  /**
   * Returns the next supplied `byte[]` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `byte[]` value
   * @throws IllegalStateException if no next value has been supplied
   */
  byte[] nextByteArray();

  /**
   * Returns the next supplied `double` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `double` value
   * @throws IllegalStateException if no next value has been supplied
   */
  double nextDouble();

  /**
   * Returns the next supplied `float` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `float` value
   * @throws IllegalStateException if no next value has been supplied
   */
  float nextFloat();

  /**
   * Returns the next supplied `integer` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `integer` value
   * @throws IllegalStateException if no next value has been supplied
   */
  int nextInteger();

  /**
   * Returns the next supplied `long` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `long` value
   * @throws IllegalStateException if no next value has been supplied
   */
  long nextLong();

  /**
   * Sets the next one or more `boolean` values.
   *
   * @param value the next `boolean` value
   * @param values additional `boolean` values
   */
  void setNextValue(boolean value, boolean... values);

  /**
   * Sets the next one or more `byte` values.
   *
   * @param value the next `byte` value
   * @param values additional `byte` values
   */
  void setNextValue(byte value, byte... values);

  /**
   * Sets the next one or more `byte[]` values.
   *
   * @param value the next `byte[]` value
   * @param values additional `byte[]` values
   */
  void setNextValue(byte[] value, byte[]... values);

  /**
   * Sets the next one or more `double` values.
   *
   * @param value the next `double` value
   * @param values additional `double` values
   */
  void setNextValue(double value, double... values);

  /**
   * Sets the next one or more `float` values.
   *
   * @param value the next `float` value
   * @param values additional `float` values
   */
  void setNextValue(float value, float... values);

  /**
   * Sets the next one or more `int` values.
   *
   * @param value the next `int` value
   * @param values additional `int` values
   */
  void setNextValue(int value, int... values);

  /**
   * Sets the next one or more `long` values.
   *
   * @param value the next `long` value
   * @param values additional `long` values
   */
  void setNextValue(long value, long... values);

  /**
   * Resets the `TestRandom` to its initial state.
   */
  void reset();

}
