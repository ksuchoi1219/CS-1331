/**
 * Represents a Card class.
 * @author Kwang Su Choi
 * @version 1.0
 */
public abstract class Card {
    protected String name;
    protected int cost;
    protected String description;
    protected boolean score;
    protected String block;
/** Represents a constructor for Card class.
* @param name name of the card
* @param cost Keeble cost
* @param description description of the card
* @param score whether this card counts as scoring
* @param block block of flavor text
*/
    public Card(String name, String block, String description,
        boolean score, int cost) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.score = score;
        this.block = block;
    }
    /** Gets a name of the card.
    * @return name of the card
    */
    public String getName() {
        return name;
    }
    /** Gets a cost of the card.
    * @return cost of the card
    */
    public int getCost() {
        return cost;
    }
    /** Gets a description of the card.
    * @return description of the card
    */
    public String getDescription() {
        return description;
    }
    /** Gets a cost of the card.
    * @return cost of the card
    */
    public boolean isScorable() {
        return score;
    }
    /** Gets a block of the card.
    * @return block of the card
    */
    public String getBlock() {
        return block;
    }
    /** Gets a hashcode of the card.
    * @return hashcode for the name of the card
    */
    public int hashCode() {
        return name.hashCode();
    }
    /** See if two objects are equal.
    * @param other is the other object that you want to compare it to.
    * @return true if two objects are equal or false otherwise
    */
    public boolean equals(Object other) {
        if (null == other) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        Card that = (Card) other;
        return this.name.equals(that.name);
    }
    /** Gets a card and remove it from player's hand.
    * @param p is the PlasterClash game.
    */
    public void play(PlasterClash p) {
        p.currentPlayer().getHand().remove(this);
    }
    /** Add card to the zone that is being played.
    * @param p is the PlasterClash game.
    */
    public void playToPlayZone(PlasterClash p) {
        p.getPlayZone().add(this);
    }
    /** Converts to string.
    * @return string of the object's address.
    */
    public String toString() {
        String string = name + " (" + cost + ")";
        return string;
    }
}