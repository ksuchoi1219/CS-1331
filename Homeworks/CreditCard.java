import java.time.LocalDate;

/**
 * CreditCard is the class that represents credit card and
 * might throw exception if something goes wrong.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */

public class CreditCard extends Card implements PaymentMethod {

    protected LocalDate expirationDate;

    /** This is the constructor of CreditCard class
    * @param ownerName is the name of the owner of the card.
    * @param balance is the balance that is saved in the card.
    * @param expirationDate is the expiration date of the card.
    */
    public CreditCard(String ownerName, double balance,
        LocalDate expirationDate) {
        super(ownerName, balance);
        this.expirationDate = expirationDate;
    }
    /** This is pay method that pays for the item with credit card.
    * @param amount is the money value of the items.
    */
    public void pay(double amount) throws PaymentFailedException {
        if (!(expirationDate.isBefore(LocalDate.now()))) {
            if (balance >= amount) {
                balance = balance - amount;
            } else {
                throw new NotEnoughFundsException("Not enough "
                 + "balance in credit card!");
            }
        } else {
            throw new CardExpiredException("Card has expired!");
        }
    }
}