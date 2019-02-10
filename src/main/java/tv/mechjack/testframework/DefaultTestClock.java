package tv.mechjack.testframework;

/**
 * The default implementation of `TestClock` used by `TestFramework`.
 */
final class DefaultTestClock implements TestClock {

  private Long currentTime = 0L;

  @Override
  public final Long currentTime() {
    return this.currentTime;
  }

  @Override
  public final void currentTimeDelta(final long timeDelta) {
    this.currentTime += timeDelta;
  }

  @Override
  public void reset() {
    this.currentTime = 0L;
  }

}
