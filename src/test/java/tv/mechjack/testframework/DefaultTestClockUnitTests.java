package tv.mechjack.testframework;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.TimeUnit;

import org.junit.Rule;
import org.junit.Test;

public final class DefaultTestClockUnitTests {

  @Rule
  final public TestFramework testFramework = new TestFramework();

  @Test
  public final void currentTime_noChangeInTime_resultIsZero() {
    final DefaultTestClock testClock = new DefaultTestClock();

    final long result = testClock.currentTime();

    assertThat(result).isZero();
  }

  @Test
  public final void currentTime_updateTimeInMilliseconds_resultIsUpdatedTime() {
    final long delta = this.testFramework.arbitraryData().getLong();
    final DefaultTestClock testClock = new DefaultTestClock();

    testClock.updateTime(delta);
    final long result = testClock.currentTime();

    assertThat(result).isEqualTo(delta);
  }

  @Test
  public final void currentTime_updateTimeInMinutes_resultIsUpdatedTime() {
    final long delta = this.testFramework.arbitraryData().getLong();
    final DefaultTestClock testClock = new DefaultTestClock();

    testClock.updateTime(delta, TimeUnit.MINUTES);
    final long result = testClock.currentTime();

    assertThat(result).isEqualTo(TimeUnit.MINUTES.toMillis(delta));
  }

  @Test
  public final void currentTime_updateTimeInMinutesWithShift_resultIsUpdatedTime() {
    final long delta = this.testFramework.arbitraryData().getLong();
    final long shift = this.testFramework.arbitraryData().getLong();
    final DefaultTestClock testClock = new DefaultTestClock();

    testClock.updateTime(delta, TimeUnit.MINUTES, shift);
    final long result = testClock.currentTime();

    assertThat(result).isEqualTo(TimeUnit.MINUTES.toMillis(delta) + shift);
  }

  @Test
  public final void reset_whenCalled_resultIsTimeResetToZero() {
    final DefaultTestClock testClock = new DefaultTestClock();
    testClock.updateTime(this.testFramework.arbitraryData().getLong(),
        TimeUnit.MINUTES);

    testClock.reset();
    final long result = testClock.currentTime();

    assertThat(result).isZero();
  }

}
