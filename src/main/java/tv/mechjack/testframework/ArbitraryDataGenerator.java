package tv.mechjack.testframework;

/**
 * A source of test data when the specific value doesn't matter. The
 * `DefaultArbitraryDataGenerator` will generate values for your tests that are unique.
 * <p>
 * This class is available to be injected via Guice or through the
 * `TestFramework`.
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
 *     final DefaultArbitraryDataGenerator arbitraryDataGenerator =
 *         this.testFramework.getInstance(testFrameworkRule.class);
 *     final MyService subjectUnderTest = new MyService();
 *
 *     final Object result = subjectUnderTest.doSomething(
 *         arbitraryDataGenerator.getString());
 *
 *     Assertions.assertThat(result).isNotNull();
 *   }
 *
 * }
 * ```
 *
 * ## Convenience Methods on `TestFramework`
 *
 * This pattern is common enough that there are convenience on
 * `TestFramework` that wrap the `DefaultArbitraryDataGenerator` instance.
 *
 * ```java
 * public final class MyServiceUnitTests {
 *
 *  {@literal @}Rule
 *   public final TestFramework testFramework = new TestFramework();
 *
 *  {@literal @}Test
 *   public final void testSomeServiceMethod() {
 *     final MyServiceTest subjectUnderTest = new MyServiceTest();
 *
 *     final Object result = subjectUnderTest.doSomething(
 *         this.testFramework.getArbitraryString());
 *
 *     Assertions.assertThat(result).isNotNull();
 *   }
 *
 * }
 * ```
 */
public interface ArbitraryDataGenerator {

  /**
   * Returns an arbitrary `byte` value.
   *
   * @return an arbitrary `byte` value
   */
  byte getByte();

  /**
   * Returns an arbitrary `byte[]` value.
   *
   * @return an arbitrary `byte[]` value
   */
  byte[] getByteArray();

  /**
   * Returns an arbitrary `char` value.
   *
   * @return an arbitrary `char` value
   */
  char getCharacter();

  /**
   * Returns an arbitrary `double` value.
   *
   * @return an arbitrary `double` value
   */
  double getDouble();

  /**
   * Returns an arbitrary `float` value.
   *
   * @return an arbitrary `float` value
   */
  float getFloat();

  /**
   * Returns an arbitrary `int` value.
   *
   * @return an arbitrary `int` value
   */
  int getInteger();

  /**
   * Returns an arbitrary `long` value.
   *
   * @return an arbitrary `long` value
   */
  long getLong();

  /**
   * Returns an arbitrary `short` value.
   *
   * @return an arbitrary `short` value
   */
  short getShort();

  /**
   * Returns an arbitrary `String` value.
   *
   * @return an arbitrary `String` valueå
   */
  String getString();

}
