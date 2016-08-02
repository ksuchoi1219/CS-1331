/**
 * Represents a Keeble card.
 *
 * @author Taylor Burdette
 * @version 1.0
 */
public class Keeble extends Card {
    /**
     * Constructs a Keeble object. It is not scorable.
     */
    public Keeble() {
        super("Keeble", "Add 1 to the current keeble count.",
                "A fun-loving keeble out to bake some cookies.",
                false, 1);
    }

    /**
     * Gives the player 1 Keeble.
     *
     * @param p the game object to affect
     */
    public void play(PlasterClash p) {
        super.play(p);
        playToPlayZone(p);
        p.incKeebles();
    }

}
