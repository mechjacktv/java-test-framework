package tv.mechjack.testframework;

/**
 * A source of test data when the specific value doesn't matter. The
 * `DefaultArbitraryData` will generate values for your tests that are unique.
 *
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
 *     final ArbitraryData arbitraryData = this.testFramework.arbitraryData();
 *     final DataSource dataSource = new TestDataSource(arbitraryData);
 *     final MyService subjectUnderTest = new MyService();
 *     final Object result = subjectUnderTest
 *         .doSomething(arbitraryData.getString());
 *
 *     // additional test code
 *   }
 *
 * }
 * ```
 */
public interface ArbitraryData {

  /**
   * Constant that can be used when a collection of arbitrary size is needed.
   * Value is `20`.
   */
  int ARBITRARY_COLLECTION_SIZE = 20;

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
