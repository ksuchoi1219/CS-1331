/**
 * Represents a Giant Keeble which is my custome card class.
 * @author Kwang Su Choi
 * @version 1.0
 */

public class GiantKeeble extends Card {
    /**
     * Constructs a Giant Gnome object. It is not scorable.
     */
    public GiantKeeble() {
        super("Giant Keeble", "Throw away your card!",
                "This giant keeble will make you drop a card "
                + "because it is so scary!",
                false, 2);
    }

    /**
     * Makes a current player to discard a card randomly from hand.
     *
     * @param p the game object to affect
     */
    public void play(PlasterClash p) {
        super.play(p);
        Player player = p.currentPlayer();
        player.discardRandom();
    }
}