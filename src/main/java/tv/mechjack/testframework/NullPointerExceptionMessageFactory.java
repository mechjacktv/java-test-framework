package tv.mechjack.testframework;

/**
 * A callback interface for asserting the message supplied by
 * `NullPointerException`.
 */
public interface NullPointerExceptionMessageFactory {

  /**
   * Factory method for generating the expected `NullPointerException` message.
   *
   * @return the expected `NullPointerException` message
   */
  String createMessage();

  /**
   * Factory method for generating the expected `NullPointerException` message
   * which includes the specified `name`.
   *
   * @return the expected `NullPointerException` message
   */
  String createMessage(String name);

}
