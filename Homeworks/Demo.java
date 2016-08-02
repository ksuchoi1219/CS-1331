import java.time.LocalDate;
/**
 * Demo is the class that represents demo and run the checking out item program.
 *
 * @author Kwang Su Choi
 * @version 1.0
 */
public class Demo {

    /** This is the main method in Demo class.
    * @param args is the argument for the main method.
    */

    public static void main(String[] args) {

        String storeName = "TechConvenience";
        String wrongName = "WrongStore";

        Cash cash = new Cash(100);
        CreditCard creditCard = new CreditCard("John", 500.00,
            LocalDate.of(2014, 12, 12));
        BuzzCard buzzCard = new BuzzCard("Kim", 500.00);

        Item invalidItem = new Item("apple", 0.5, 1.5, 1234);
        Item groundCoffee = new Item("Ground Coffee", 961.05,
            9.68, 9220570);
        Item ramen = new Item("Ramen 12-pack", 74.84, 17.21, 12);
        Item macAndCheese = new Item("Mac and Cheese 5 pack",
            1028.8, 4.5, 9237204);
        Item pizza = new Item("Frozen pizza", 902.93, 2.98, 9263670);
        Item energyDrink = new Item("Energy Drink 10-pack",
            546.86, 17.89, 550759400);


        CheckoutMachine checkoutMachine = null;
        // Should throw when the args[0] is not "TechConvenience".
        // In this case, it should not throw exception.
        try {
            checkoutMachine = new CheckoutMachine(storeName);
        } catch (WrongStoreError wse) {
            System.out.println(wse);
        }
        try {
            checkoutMachine = new CheckoutMachine(wrongName);
        } catch (WrongStoreError wse) {
            System.out.println(wse);
        }
        // Should throw when checkoutMachine has scanned the invalid item.
        try {
            checkoutMachine.scan(invalidItem);
        } catch (InvalidItemException iie) {
            System.out.println(iie);
        }
        // Should not throw because "pizza" is one of the valid items.
        try {
            checkoutMachine.scan(pizza);
        } catch (InvalidItemException iie) {
            System.out.println(iie);
        }
        // Should throw NotEnoughFundsException
        // because $150 is over "cashOnHand".
        try {
            cash.pay(150);
        } catch (NotEnoughFundsException nfe) {
            System.out.println(nfe);
        } catch (PaymentFailedException pfe) {
            System.out.println(pfe);
        }
        // Should throw CardExpiredException because LocalDate is before today.
        try {
            creditCard.pay(50);
        } catch (NotEnoughFundsException nfe) {
            System.out.println(nfe);
        } catch (CardExpiredException cee) {
            System.out.println(cee);
        } catch (PaymentFailedException pfe) {
            System.out.println(pfe);
        }
    }
}