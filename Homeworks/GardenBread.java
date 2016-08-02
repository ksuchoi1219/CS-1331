/**
 * Represents a Garden Bread card.
 *
 * @author Taylor Burdette
 * @version 1.0
 */
public class GardenBread extends Card {
    /**
     * Constructs a Garden Bread object. It is not scorable.
     */
    public GardenBread() {
        super("Garden Bread", "Add 2 to the current keeble count.",
                "Delicious bread, straight from the garden oven!",
                false, 2);
    }

    /**
     * Gives the current player 2 Keebles.
     *
     * @param p the game object to affect
     */
    public void play(PlasterClash p) {
        super.play(p);
        playToPlayZone(p);
        p.incKeebles();
        p.incKeebles();
    }
}
