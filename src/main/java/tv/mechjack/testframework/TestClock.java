package tv.mechjack.testframework;

import java.util.concurrent.TimeUnit;

/**
 * Provides fine grained control over the apparent time unit tests are running.
 * Tests are run at random times and take variable lengths of time to run.
 * Implementations that access the time should abstract their access behind an
 * interface that can be faked during testing. A test implementation can wrap an
 * implementation of this interface, which will automatically be reset if the
 * test class is using the instance supplied by the `TestFramework`.
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
 *     final TestClock testClock = this.testFramework.testClock();
 *     final TimeSource timeSource = new TestTimeSource(testClock);
 *     final MyService subjectUnderTest = new MyService(timeSource);

 *     // additional test code with current time set to 0
 *     testClock.updateTime(1000);
 *     // additional test code with current time set to 1000
 *   }
 *
 * }
 * ```
 */
public interface TestClock {

  /**
   * Returns the apparent current time. A new or `reset` instance of this class
   * will return `0`.
   *
   * @return the apparent current time
   */
  Long currentTime();

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in milliseconds.
   *
   * @param delta the change in time
   */
  void updateTime(final Integer delta);

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in milliseconds.
   *
   * @param delta the change in time
   */
  void updateTime(final Long delta);

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in the `TimeUnit` specified.
   *
   * @param delta the change in time
   * @param unit the `TimeUnit` for the change in time
   */
  void updateTime(Integer delta, TimeUnit unit);

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in the `TimeUnit` specified.
   *
   * @param delta the change in time
   * @param unit the `TimeUnit` for the change in time
   */
  void updateTime(Long delta, TimeUnit unit);

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in the `TimeUnit` specified plus a "shift"
   * measured in milliseconds if a fraction of the specified `TimeUnit` is
   * needed.
   *
   * @param delta the change in time
   * @param unit the `TimeUnit` for the change in time
   * @param shift additional milliseconds applied to the delta
   */
  void updateTime(Integer delta, TimeUnit unit, Integer shift);

  /**
   * Adds (or subtracts if `delta` is negative) the `delta` value to the time
   * returned by the `TestClock` in the `TimeUnit` specified plus a "shift"
   * measured in milliseconds if a fraction of the specified `TimeUnit` is
   * needed.
   *
   * @param delta the change in time
   * @param unit the `TimeUnit` for the change in time
   * @param shift additional milliseconds applied to the delta
   */
  void updateTime(Long delta, TimeUnit unit, Long shift);

  /**
   * Resets the `TestClock` to its initial state.
   */
  void reset();

}
