package tv.mechjack.testframework;

/**
 * A non-random source of "random" values used during unit testing. Real random
 * values and unit tests don't mix. Implementations that require random values
 * should abstract their access behind an interface that can be faked during
 * testing. A test implementation can wrap an implementation of this interface,
 * which will automatically be reset if the test class is using the instance
 * supplied by the `TestFramework`.
 *
 * ## Example Use
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 *  {@literal @}Test
 *   public final void testSomeServiceMethod() {
 *     final TestRandom testRandom = this.testFramework.testRandom();
 *     final RandomSource randomSource = new TestRandomSource(testRandom);
 *     final MyService subjectUnderTest = new MyService(randomSource);

 *     testRandom.setNextValues(1000L)
 *     // additional test code
 *   }
 *
 * }
 * ```
 */
public interface TestRandom {

  /**
   * Returns the next supplied `boolean` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `boolean` value
   * @throws IllegalStateException if no next value has been supplied
   */
  Boolean nextBoolean();

  /**
   * Returns the next supplied `byte` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `byte` value
   * @throws IllegalStateException if no next value has been supplied
   */
  Byte nextByte();

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
  Double nextDouble();

  /**
   * Returns the next supplied `float` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `float` value
   * @throws IllegalStateException if no next value has been supplied
   */
  Float nextFloat();

  /**
   * Returns the next supplied `integer` values or throws an
   * `IllegalStateException` if no more values are available.
   *
   * @return the next supplied `integer` value
   * @throws IllegalStateException if no next value has been supplied
   */
  Integer nextInteger();

  /**
   * Returns the next supplied `long` values or throws an `IllegalStateException`
   * if no more values are available.
   *
   * @return the next supplied `long` value
   * @throws IllegalStateException if no next value has been supplied
   */
  Long nextLong();

  /**
   * Sets the next one or more `boolean` values.
   *
   * @param values the next `boolean` values
   */
  void setNextValues(Boolean... values);

  /**
   * Sets the next one or more `byte` values.
   *
   * @param values the next `byte` values
   */
  void setNextValues(Byte... values);

  /**
   * Sets the next one or more `byte[]` values.
   *
   * @param values the next `byte[]` values
   */
  void setNextValues(byte[]... values);

  /**
   * Sets the next one or more `double` values.
   *
   * @param values the next `double` values
   */
  void setNextValues(Double... values);

  /**
   * Sets the next one or more `float` values.
   *
   * @param values the next `float` values
   */
  void setNextValues(Float... values);

  /**
   * Sets the next one or more `int` values.
   *
   * @param values the next `int` values
   */
  void setNextValues(Integer... values);

  /**
   * Sets the next one or more `long` values.
   *
   * @param values the next `long` values
   */
  void setNextValues(Long... values);

  /**
   * Resets the `TestRandom` to its initial state.
   */
  void reset();

}
