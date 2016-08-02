import java.util.Random;

/**
 * Represents a player in the Game of PlasterClash.
 * A player has a hand, a tree (deck) and a discard pile.
 * When the tree is empty, the discard is shuffled back into it.
 *
 * @author Taylor Burdette &amp; Thomas Shields
 * @version 1.0
 */
public class Player {
    private static int index = 0;
    private int myIndex;
    private Zone tree, hand, trashHeap;
    private int maxHandSize;

    /**
     * Constructs a Player object. Players have a Tree, Hand, and Trashheap.
     * Players have a max handsize of 5 and draw at the start of the game.
     */
    public Player() {
        tree = new Tree();
        hand = new Zone();
        trashHeap = new Zone();
        maxHandSize = 5;
        tree.shuffle();
        endPlayerTurn();
        myIndex = index++;
    }

    /**
     * Adds the number of Gnomes in the player's zones.
     *
     * @return the number of Gnomes the player has
     */
    public int numGnomes() {
        return tree.numGnomes() + hand.numGnomes() + trashHeap.numGnomes();
    }

    /**
     * Ends the player's turn. The player tosses their old hand
     * and draws 5 new cards.
     */
    public void endPlayerTurn() {
        discardHand();
        for (int i = 0; i < maxHandSize; i++) {
            drawCard();
        }
    }

    /**
     * Draws a card from the top of the Tree. If the tree is empty,
     * it shuffles the trashheap in.
     */
    public void drawCard() {
        if (tree.size() > 0) {
            hand.add(tree.remove(0));
        } else if (trashHeap.size() > 0) {
            trashHeap.moveCardsTo(tree);
            tree.shuffle();
            hand.add(tree.remove(0));
        }
    }

    /**
     * Discards all cards from the hand to the trashheap.
     */
    public void discardHand() {
        hand.moveCardsTo(trashHeap);
    }

    /**
     * If the player's hand contains cards.
     *
     * @return if the hand has cards in it
     */
    public boolean hasHand() {
        return hand.size() > 0;
    }

    /**
     * Discards a random card from to hand to the trashheap.
     */
    public void discardRandom() {
        Random rand = new Random();
        int idx = rand.nextInt(hand.size());
        discardCard(idx);
    }

    /**
     * Discards a card by index.
     *
     * @param idx the index of the card to be discarded.
     */
    public void discardCard(int idx) {
        Card randy = hand.get(idx);
        trashHeap.add(randy);
        hand.remove(idx);
    }

    /**
     * Discards a card if the hand contains it.
     *
     * @param c the card to be discarded
     */
    public void discardCard(Card c) {
        if (hand.contains(c)) {
            trashHeap.add(c);
            hand.remove(c);
        }
    }

    /**
     * Get the player's hand.
     *
     * @return the player's hand
     */
    public Zone getHand() {
        return hand;
    }

    /**
     * Get the player's tree.
     *
     * @return the player's tree
     */
    public Zone getTree() {
        return tree;
    }

    /**
     * Get the player's trashheap.
     *
     * @return the player's trashheap
     */
    public Zone getTrashHeap() {
        return trashHeap;
    }

    @Override
    public String toString() {
        return "Player " + myIndex;
    }

}
