package tv.mechjack.testframework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public final class ArbitraryDataGeneratorUnitTests {

  public static final int VALUES_TO_COMPARE = 20;

  @Rule
  public final JUnitSoftAssertions softly = new JUnitSoftAssertions();

  @Test
  public final void getByte_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getByte, Byte::equals);
  }

  private <T> void assertThatValuesAreUnique(final Supplier<T> supplier,
      final Comparator<T> comparator) {
    final List<T> pastResults = new ArrayList<>();

    for (int i = 0; i < VALUES_TO_COMPARE; i++) {
      final T result = supplier.get();

      for (final T pastResult : pastResults) {
        softly.assertThat(comparator.equals(pastResult, result)).isFalse();
      }
      pastResults.add(result);
    }
  }

  @Test
  public final void getByteArray_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getByteArray,
        Arrays::equals);
  }

  @Test
  public final void getCharacter_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getCharacter,
        Character::equals);
  }

  @Test
  public final void getDouble_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getDouble, Double::equals);
  }

  @Test
  public final void getFloat_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getFloat, Float::equals);
  }

  @Test
  public final void getInteger_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getInteger,
        Integer::equals);
  }

  @Test
  public final void getLong_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getLong, Long::equals);
  }

  @Test
  public final void getShort_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getShort, Short::equals);
  }

  @Test
  public final void getString_whenCalledMultipleTimes_resultIsUniqueValues() {
    final ArbitraryDataGenerator subjectUnderTest = new ArbitraryDataGenerator();

    this.assertThatValuesAreUnique(subjectUnderTest::getString, String::equals);
  }

  private interface Comparator<T> {

    boolean equals(T t1, T t2);

  }

}
