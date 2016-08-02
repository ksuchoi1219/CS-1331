import java.util.ArrayList;
/**
 * Represents a Gnome class which extends to Card
 * and it is worth victory points.
 * @author Kwang Su Choi
 * @version 1.0
 */

public class Gnome extends Card {
    /**
     * Constructs a Gnome object. It is scorable.
     */
    public Gnome() {
        super("Gnome", "Worth victory points.",
                "Creepy looking doll in your yard!",
                true, 4);
    }
    /**
     * Makes every other player to randomly discard a card.
     * Also, gnomes are removed from the game entirely once they are played.
     * @param p the game object to affect
     */
    public void play(PlasterClash p) {
        super.play(p);
        ArrayList<Player> opponents = p.opponents();
        for (Player opps : opponents) {
            opps.discardRandom();
        }
    }
}