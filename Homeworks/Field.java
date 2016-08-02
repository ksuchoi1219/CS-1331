import java.util.ArrayList;
import java.util.HashMap;
/**
 * Represents a Field class which is a set of cards
 * the player can purchase.
 * @author Kwang Su Choi
 * @version 1.0
 */

public class Field {

    private HashMap<Card, Integer> purchasable;
    /** Constructors for Field class.
    * Puts almost infinite number of Garden Bread,
    * 10 Giant Keebles, and 10 Gnomes.
    */
    public Field() {
        this.purchasable = new HashMap<Card, Integer>();
        purchasable.put(new GardenBread(), 999999999);
        purchasable.put(new GiantKeeble(), 10);
        purchasable.put(new Gnome(), 10);
    }
    /** Buys a card from Field.
    * @param c is the card that you want to buy.
    */
    public void buyCard(Card c) {
        if (purchasable.containsKey(c) && !c.getName().equals("Garden Bread")) {
            purchasable.put(c, purchasable.get(c) - 1);
        }
    }
    /** Shows what kind of cards that are left in the Field.
    * @return listOfCards is the list of cards that are available in the Shop.
    */
    public ArrayList<Card> cards() {
        ArrayList<Card> listOfCards = new ArrayList<>();
        for (Card card : purchasable.keySet()) {

            listOfCards.add(card);
        }
        return listOfCards;
    }
}