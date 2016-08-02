/**
 * Card is the class that represents card and might throw
 * exception if something goes wrong.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public abstract class Card implements PaymentMethod {

    protected String ownerName;
    protected double balance;
    /** This is the constructor of Card class
    * @param ownerName is the name of the owner of the card.
    * @param balance is the balance that is saved in the card.
    */
    public Card(String ownerName, double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }
    /** This is pay method that pays for the item with card.
    * @param amount is the money value of the items.
    */
    public void pay(double amount) throws PaymentFailedException {
        if (balance >= amount) {
            balance = balance - amount;
        } else {
            throw new NotEnoughFundsException("Not enough balance in card!");
        }
    }
}