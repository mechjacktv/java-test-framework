package tv.mechjack.testframework;

import java.util.concurrent.TimeUnit;

/**
 * The default implementation of `TestClock` used by `TestFramework`.
 */
public final class DefaultTestClock implements TestClock {

  private Long currentTime = 0L;

  @Override
  public final Long currentTime() {
    return this.currentTime;
  }

  @Override
  public final void currentTimeDelta(final long delta) {
    this.currentTimeDelta(delta, TimeUnit.MILLISECONDS);
  }

  @Override
  public void currentTimeDelta(final long delta, final TimeUnit unit) {
    this.currentTimeDelta(delta, unit);
  }

  @Override
  public void currentTimeDelta(final long delta, final TimeUnit unit,
      final long shift) {
    this.currentTime += (unit.toMillis(delta) + shift);
  }

  @Override
  public void reset() {
    this.currentTime = 0L;
  }

}
