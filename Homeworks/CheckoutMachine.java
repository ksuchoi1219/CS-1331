import java.util.ArrayList;
/**
 * Checkout Machine is the class that represents checkout machine
 * and returns the total price and might throw
 * exception if something goes wrong.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */

public class CheckoutMachine {

    private String storeName;
    private ArrayList<Item> validItems;
    private ArrayList<Item> cart;
    /** This is CheckoutMachine constructor which may throw WrongStoreError.
    * @param storeName is the name of the store. If ths is invalid,
    * it throws WrongStoreError.
    */

    public CheckoutMachine(String storeName) throws WrongStoreError {
        boolean validName = false;
        boolean continueOn = true;
        validItems = new ArrayList<Item>();
        cart = new ArrayList<Item>();
        while (continueOn) {
            try {
                validName = Server.isStoreNameValid(storeName);
                validItems = Server.getValidItems();
                continueOn = false;
                if (validName) {
                    this.storeName = storeName;
                } else {
                    throw new WrongStoreError("This is not the right store!");
                }
            } catch (ServerException s) {
                System.out.println("The server may be down.");
            }
        }
    }
    /** This is scan method in CheckoutMachine class that scans items
    * and determines if the item is valid or not.
    * @param item is the item that passes in from the main method.
    */
    public void scan(Item item) throws InvalidItemException {
        if (validItems.contains(item)) {
            cart.add(validItems.get(validItems.indexOf(item)));
        } else {
            throw new InvalidItemException("This item is invalid!");
        }
    }
    /** This is getTotalPrice method that sums up the total price of items.
    * @return totalPrice is the amount of price that needs to be paid.
    */
    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : cart) {
            totalPrice = totalPrice + item.getPrice();
        }
        return totalPrice;
    }
    /** This is the payForCart method that pays the price
    * according to user's choice
    * of paying method, and then empties the cart.
    * @param method is the type of payment method by the user.
    */
    public void payForCart(PaymentMethod method) throws PaymentFailedException {
        method.pay(this.getTotalPrice());
        cart.clear();
    }
}