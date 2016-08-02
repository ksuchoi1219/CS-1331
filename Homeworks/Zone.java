import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 * Represents a Zone class in which cards can reside.
 * @author Kwang Su Choi
 * @version 1.0
 */

public class Zone implements Iterable {

    protected ArrayList<Card> cardDeck;
/** Constructor for Zone class.
*/
    public Zone() {
        this.cardDeck = new ArrayList<Card>();
    }
    /** Allows cardDeck to be iterable.
    * @return Iterator that enables us to iterate through card deck.
    */
    public Iterator iterator() {
        return cardDeck.iterator();
    }
    /** Shuffles the card deck.
    */
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }
    /** Converts to String.
    * @return string version of the object's address.
    */
    public String toString() {
        int i = 0;
        String string = i + ": " + cardDeck.get(i).getName()
            + " " + "(" + cardDeck.get(i).getCost() + ")\n";
        for (i = 1; i < cardDeck.size(); i++) {
            String name = cardDeck.get(i).getName();
            int cost = cardDeck.get(i).getCost();
            string += String.valueOf(i) + ": " + name
                + " (" + String.valueOf(cost) + ")\n";
        }
        return string;
    }
    /** Moves cards to a specific zone.
    * @param z is the zone that you want your cards to move to.
    */
    public void moveCardsTo(Zone z) {
        for (Card card : cardDeck) {
            z.add(card);
        }
        cardDeck.clear();
    }
    /** Adds a card to the deck.
    * @param c is the card that you want to add.
    */
    public void add(Card c) {
        cardDeck.add(c);
    }
    /** Removes a card from the deck.
    * @param c is the card that you want to remove.
    * @return boolean value of whether the method has removed or not.
    */
    public boolean remove(Card c) {
        return cardDeck.remove(c);
    }
    /** Removes a card from the deck by its index.
    * @param index is the index of the card in the card deck.
    * @return removedCard is the card that is being removed.
    */
    public Card remove(int index) {
        Card removedCard = cardDeck.get(index);
        cardDeck.remove(cardDeck.get(index));
        return removedCard;
    }
    /** Discards all the cards from the zone.
    * @return temporary is the array list of cards that is being discarded out.
    */
    public ArrayList<Card> discardAll() {
        ArrayList<Card> temporary = new ArrayList<>(cardDeck);
        cardDeck.clear();
        return temporary;
    }
    /** Returns the number of gnomes in the card deck.
    * @return numGnomes is the number of gnomes.
    */
    public int numGnomes() {
        int numGnomes = 0;
        for (Card gnomes : cardDeck) {
            if (gnomes.getName().equals("Gnome")) {
                numGnomes += 1;
            }
        }
        return numGnomes;
    }
    /** Tests if the card deck contains a specific card.
    * @param c is the card that you want to check whether
    * the card deck contains it or not.
    * @return boolean value of whether the card deck contains the card.
    */
    public boolean contains(Card c) {
        return cardDeck.contains(c);
    }
    /** Returns the size of the card deck.
    * @return int of size of the card deck.
    */
    public int size() {
        return cardDeck.size();
    }
    /** Returns the card from the card deck by its index.
    * @param i is the index of the card in the card deck.
    * @return Card is the card that is in the card deck.
    */
    public Card get(int i) {
        return cardDeck.get(i);
    }
}