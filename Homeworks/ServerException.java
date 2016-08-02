/**
 * ServerException gets thrown by the server when something goes wrong.
 *
 * @author Alex Epifano
 * @version 1.0
 */
public class ServerException extends Exception {
    /**
     * Creates a new ServerException with the given message.
     * @param  msg The message of the exception.
     */
    public ServerException(String msg) {
        super(msg);
    }
    /**
     * Creates a new ServerException.
     */
    public ServerException() {
        super();
    }
}
