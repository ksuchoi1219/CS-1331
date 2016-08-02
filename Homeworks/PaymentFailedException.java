/**
 * PaymentFailedException gets thrown by the server
 * when something goes wrong in payment.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class PaymentFailedException extends Exception {
    /**
     * Creates a new PaymentFailedException with the given message.
     * @param  msg The message of the exception.
     */
    public PaymentFailedException(String msg) {
        super(msg);
    }
    /**
     * Creates a new PaymentFailedException.
     */
    public PaymentFailedException() {
        super();
    }
}