/**
 * CardExpiredException gets thrown by the server
 * when the expiration date is over.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class CardExpiredException extends PaymentFailedException {
    /**
     * Creates a new CardExpiredException with the given message.
     * @param  msg The message of the exception.
     */
    public CardExpiredException(String msg) {
        super(msg);
    }
    /**
     * Creates a new CardExpiredException.
     */
    public CardExpiredException() {
        super();
    }
}