/**
 * Interface PaymentMethod guarantees implementing classes have a pay method
 * in order to pay for things.
 *
 * @author Alex Epifano
 * @version 1.0
 */
public interface PaymentMethod {
    /**
     * Pays the given amount if possible, throws a PaymentFailedException if
     * something goes wrong.
     * @param  amount                 Amount of money to pay.
     * @throws PaymentFailedException Thrown if something goes wrong.
     */
    void pay(double amount) throws PaymentFailedException;
}
