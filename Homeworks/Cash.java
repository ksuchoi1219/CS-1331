/**
 * Cash is the class that represents cash and might
 * throw exception if something goes wrong.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class Cash implements PaymentMethod {

    private double cashOnHand;
    /** This is the constructor of Cash class
    * @param cashOnHand is the double value of cash on hand.
    */
    public Cash(double cashOnHand) {
        this.cashOnHand = cashOnHand;
    }
    /** This is pay method that pays for the item with cash.
    * @param amount is the money value of the items.
    */
    public void pay(double amount) throws PaymentFailedException {
        if (cashOnHand >= amount) {
            cashOnHand = cashOnHand - amount;
        } else {
            throw new NotEnoughFundsException("Not enough cash!");
        }
    }
}