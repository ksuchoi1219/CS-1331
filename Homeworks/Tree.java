/**
 * Represents a Tree class which is a special Zone that
 * comes with cards at the start.
 * @author Kwang Su Choi
 * @version 1.0
 */

public class Tree extends Zone {

/** Constructor for Tree class which adds 9 Keebles and 1 Gnome.
*/
    public Tree() {
        super();
        cardDeck.add(new Gnome());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
        cardDeck.add(new Keeble());
    }
}