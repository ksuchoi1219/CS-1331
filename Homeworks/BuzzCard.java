/**
 * BuzzCard is the class that represents buzzcard that works same
 * as credit card and might throw exception if something goes wrong.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class BuzzCard extends Card implements PaymentMethod {
    /** This is the constructor of BuzzCard class
    * @param ownerName is the name of the owner of the card.
    * @param balance is the balance that is saved in the card.
    */

    public BuzzCard(String ownerName, double balance) {
        super(ownerName, balance);
    }
    /** This is pay method that pays for the item with credit card.
    * @param amount is the money value of the items.
    */
    public void pay(double amount) throws PaymentFailedException {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException("Not enough "
                + "balance in buzzcard!");
        }
    }
}