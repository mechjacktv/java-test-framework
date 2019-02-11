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
  public final void updateTime(final Long delta) {
    this.updateTime(delta, TimeUnit.MILLISECONDS);
  }

  @Override
  public void updateTime(final Long delta, final TimeUnit unit) {
    this.updateTime(delta, unit, 0L);
  }

  @Override
  public void updateTime(final Long delta, final TimeUnit unit,
      final Long shift) {
    this.currentTime += (unit.toMillis(delta) + shift);
  }

  @Override
  public void reset() {
    this.currentTime = 0L;
  }

}
