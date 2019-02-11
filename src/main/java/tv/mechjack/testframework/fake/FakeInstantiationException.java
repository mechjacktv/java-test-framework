package tv.mechjack.testframework.fake;

/**
 * A `RuntimeException` wrapper around checked `Exception`s that might be thrown
 * while creating a fake interface implementation.
 */
public class FakeInstantiationException extends RuntimeException {

  /**
   * Constructs a new `FakeInstantiationException` which wraps the `Throwable`
   * provided.
   *
   * @param cause the root cause `Throwable`
   */
  public FakeInstantiationException(final Throwable cause) {
    super(cause.getMessage(), cause);
  }

}
