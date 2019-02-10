package tv.mechjack.testframework;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static tv.mechjack.testframework.ArbitraryData.ARBITRARY_COLLECTION_SIZE;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.junit.Rule;
import org.junit.Test;

public class DefaultTestRandomUnitTests {

  @Rule
  final public TestFramework testFramework = new TestFramework();

  private <T> List<T> givenAListOfValues(final Supplier<T> supplier) {
    final List<T> values = new ArrayList<>();

    for (int i = 0; i < ARBITRARY_COLLECTION_SIZE; i++) {
      values.add(supplier.get());
    }
    return values;
  }

  @Test
  public final void randomBooleans_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Boolean[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getLong() % 2 == 0)
        .toArray(new Boolean[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextBoolean,
        expected);
  }

  @Test
  public final void randomBooleans_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Boolean[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getLong() % 2 == 0)
        .toArray(new Boolean[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextBoolean,
        expected);
  }

  @Test
  public final void randomBytes_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Byte[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getByte())
        .toArray(new Byte[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextByte,
        expected);
  }

  @Test
  public final void randomBytes_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Byte[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getByte())
        .toArray(new Byte[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextByte,
        expected);
  }

  @Test
  public final void randomByteArrays_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final byte[][] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getByteArray())
        .toArray(new byte[0][]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextByteArray,
        expected);
  }

  @Test
  public final void randomByteArrays_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final byte[][] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getByteArray())
        .toArray(new byte[0][]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextByteArray,
        expected);
  }

  @Test
  public final void randomDoubles_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Double[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getDouble())
        .toArray(new Double[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextDouble,
        expected);
  }

  @Test
  public final void randomDoubles_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Double[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getDouble())
        .toArray(new Double[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextDouble,
        expected);
  }

  @Test
  public final void randomFloats_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Float[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getFloat())
        .toArray(new Float[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextFloat,
        expected);
  }

  @Test
  public final void randomFloats_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Float[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getFloat())
        .toArray(new Float[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextFloat,
        expected);
  }

  @Test
  public final void randomIntegers_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Integer[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getInteger())
        .toArray(new Integer[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextInteger,
        expected);
  }

  @Test
  public final void randomIntegers_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Integer[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getInteger())
        .toArray(new Integer[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextInteger,
        expected);
  }

  @Test
  public final void randomLongs_withEnoughValues_resultIsValuesReturnedInOrder() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Long[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getLong())
        .toArray(new Long[0]);

    withEnoughValues_resultIsValuesReturnedInOrder(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextLong,
        expected);
  }

  @Test
  public final void randomLongs_withNotEnoughValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Long[] expected = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getLong())
        .toArray(new Long[0]);

    withNotEnoughValues_resultIsIllegalStateException(
        subjectUnderTest::setNextValues,
        subjectUnderTest::nextLong,
        expected);
  }

  @Test
  public final void reset_withValues_resultIsIllegalStateException() {
    final DefaultTestRandom subjectUnderTest = new DefaultTestRandom();
    final Long[] values = this.givenAListOfValues(
        () -> this.testFramework.arbitraryData().getLong())
        .toArray(new Long[0]);
    subjectUnderTest.setNextValues(values);

    subjectUnderTest.reset();
    final Throwable thrown = catchThrowable(subjectUnderTest::nextLong);

    assertThat(thrown).isInstanceOf(IllegalStateException.class);
  }

  private <T> void withEnoughValues_resultIsValuesReturnedInOrder(
      final Consumer<T[]> consumerMethodUnderTest,
      final Supplier<T> supplierMethodUnderTest,
      final T[] expected) {
    final List<T> results = new ArrayList<>();

    consumerMethodUnderTest.accept(expected);
    for (int i = 0; i < expected.length; i++) {
      results.add(supplierMethodUnderTest.get());
    }
    assertThat(results).containsExactly(expected);
  }

  private <T> void withNotEnoughValues_resultIsIllegalStateException(
      final Consumer<T[]> consumerMethodUnderTest,
      final Supplier<T> supplierMethodUnderTest,
      final T[] expected) {
    consumerMethodUnderTest.accept(expected);
    final Throwable thrown = catchThrowable(() -> {
      for (int i = 0; i <= expected.length; i++) {
        supplierMethodUnderTest.get();
      }
    });
    assertThat(thrown).isInstanceOf(IllegalStateException.class);
  }

}
