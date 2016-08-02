/**
 * WrongStoreError gets thrown by the server when
 * competing store makes a CheckoutMachine Object.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class WrongStoreError extends Error {
    /**
     * Creates a new WrongStoreException with the given message.
     * @param  msg The message of the exception.
     */
    public WrongStoreError(String msg) {
        super(msg);
    }
    /**
     * Creates a new WrongStoreException.
     */
    public WrongStoreError() {
        super();
    }
}