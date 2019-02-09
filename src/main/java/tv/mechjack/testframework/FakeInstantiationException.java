package tv.mechjack.testframework;

public class FakeInstantiationException extends RuntimeException {

  public FakeInstantiationException(final Throwable cause) {
    super(cause.getMessage(), cause);
  }

}
