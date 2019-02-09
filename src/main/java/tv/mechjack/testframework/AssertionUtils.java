package tv.mechjack.testframework;

import java.util.Objects;
import java.util.Optional;

import javax.inject.Inject;

import org.assertj.core.api.SoftAssertions;

/**
 * A utility class that wraps common AssertJ assertion patterns.
 *
 * This class is available to be injected via Guice or through the
 * `TestFrameworkRule`.
 */
public final class AssertionUtils {

  private final Optional<NullPointerExceptionMessageFactory> nullMessageForNameFactory;

  @Inject
  AssertionUtils(final Optional<NullPointerExceptionMessageFactory> nullMessageForNameFactory) {
    this.nullMessageForNameFactory = nullMessageForNameFactory;
  }

  /**
   * Asserts that the specified `Throwable` is a `NullPointerException` which
   * (optionally) will confirm the message if a
   * `NullPointerExceptionMessageFactory` is bound via a Guice `Module`.
   *
   * @param thrown the `Throwable` to check
   */
  public final void assertNullPointerException(final Throwable thrown) {
    this.assertNullPointerException(thrown, null);
  }

  /**
   * Asserts that the specified `Throwable` is a `NullPointerException` which
   * (optionally) will confirm the message if a
   * `NullPointerExceptionMessageFactory` is bound via a Guice `Module`.
   *
   * @param thrown the `Throwable` to check
   * @param name field name included in the message
   */
  public final void assertNullPointerException(final Throwable thrown, final String name) {
    final SoftAssertions softly = new SoftAssertions();

    softly.assertThat(thrown).isInstanceOf(NullPointerException.class);
    this.nullMessageForNameFactory.ifPresent(factory -> {
      if (Objects.nonNull(name)) {
        softly.assertThat(thrown).hasMessage(factory.createMessage(name));
      } else {
        softly.assertThat(thrown).hasMessage(factory.createMessage());
      }
    });
    softly.assertAll();
  }

}
