package tv.mechjack.testframework;

/**
 * Provides fine grained control over the apparent time unit tests are running.
 * Tests are run at random times and take variable lengths of time to run.
 * Implementations that access the time should abstract their access behind an
 * interface that can be faked during testing. A test implementation can wrap an
 * implementation of this interface, which will automatically be reset if the
 * test class is using the instance supplied by the `TestFramework`.
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
   * Adds (or subtracts if `delta` is negative) the `delta` value to current time
   * to be returned by subsequent calls to `currentTime`.
   *
   * @param delta
   */
  void currentTimeDelta(final long delta);

  /**
   * Resets the `TestClock` to its initial state.
   */
  void reset();

}
