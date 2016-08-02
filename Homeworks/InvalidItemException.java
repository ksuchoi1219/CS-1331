/**
 * InvalidItemException gets thrown by the
 * server when a user inputs an invalid item.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class InvalidItemException extends Exception {
    /**
     * Creates a new InvalidItemException with the given message.
     * @param  msg The message of the exception.
     */
    public InvalidItemException(String msg) {
        super(msg);
    }
    /**
     * Creates a new InvalidItemException.
     */
    public InvalidItemException() {
        super();
    }
}