import java.util.ArrayList;
import java.util.Scanner;

/**
 * Main class for running the PlasterClash game.
 *
 * @author Taylor Burdette
 * @version 1.0
 */
public class PlasterClash {
    private Field field;
    private ArrayList<Player> players;
    private Zone playZone;
    private int curPlayerIndex = 0;
    private int gnomeCount = 0;
    private static final int MAX_GNOMES = 10;

    private int curKeebles;

    /**
     * Constructs the PlasterClash object.
     */
    public PlasterClash() {
        players = initializePlayers();
        initializefield();
        playZone = new Zone();
    }

    /**
     * Initializes the players in the game into an ArrayList.
     *
     * @return the ArrayList of players playing the game.
     */
    private ArrayList<Player> initializePlayers() {
        // Simple modo - 4 players
        ArrayList<Player> newPlayers = new ArrayList<Player>();
        for (int i = 0; i < 4; i++) {
            newPlayers.add(new Player());
        }
        return newPlayers;
    }

    /**
     * Sets up the field field.
     */
    private void initializefield() {
        field = new Field();
    }

    /**
     * Gets the available cards as an ArrayList
     *
     * @return the ArrayList of available cards.
     */
    public ArrayList<Card> availableCards() {
        return field.cards();
    }

    /**
     * Gets the current player.
     *
     * @return the current player.
     */
    public Player currentPlayer() {
        return players.get(curPlayerIndex);
    }

    /**
     * Gets the players not currently taking their turn.
     *
     * @return An ArrayList of players not taking their turn.
     */
    public ArrayList<Player> opponents() {
        ArrayList<Player> opponents = new ArrayList<Player>(players);
        opponents.remove(currentPlayer());
        return opponents;
    }

    /**
     * Gets the cards being played this turn.
     *
     * @return the zone containing cards played this turn.
     */
    public Zone getPlayZone() {
        return playZone;
    }

    /**
     * Ends the current turn.
     */
    public void endTurn() {
        this.curKeebles = 0;
        ArrayList<Card> played = playZone.discardAll();
        for (Card card : played) {
            currentPlayer().getTrashHeap().add(card);
        }
        curPlayerIndex = (curPlayerIndex + 1) % players.size();
    }

    /**
     * Buys the chosen card from the field.
     * Throw a RuntimeException if the card cannot be bought.
     *
     * @param c the card being bought
     */
    public void buyCardFromfield(Card c) {
        if (c.getCost() <= curKeebles) {
            if (c.isScorable()) {
                incGnomeCount();
                System.out.println();
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
                System.out.printf("| Gnome captured! Conspiracy meter: %2d |%n",
                    gnomeCount);
                System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>");
                System.out.println();
            }
            field.buyCard(c);
            currentPlayer().getTrashHeap().add(c);
            curKeebles -= c.getCost();
        } else {
            throw new RuntimeException("Cannot buy card in question.");
        }
    }

    /**
     * Sets the current Keeble pool amount.
     *
     * @param keebleCount the amount of Keebles in the pool.
     */
    public void setCurKeebles(int keebleCount) {
        this.curKeebles = keebleCount;
    }

    /**
     * Increments the Keebles in the pool.
     */
    public void incKeebles() {
        addKeebles(1);
    }

    /**
     * Adds some arbitrary amount of Keebles to the pool.
     *
     * @param n the amount of Keebles to add.
     */
    public void addKeebles(int n) {
        this.curKeebles += n;
    }

    /**
     * Gets the current amount of Keebles.
     *
     * @return the number of keebles in the pool.
     */
    public int getKeebleCount() {
        return this.curKeebles;
    }

    /**
     * Adds some arbitary amount to the Conspiracy Meter.
     *
     * @param n Number of gnomes to add.
     */
    public void addGnomeCount(int n) {
        this.gnomeCount += n;
    }

    /**
     * Increments the Conspiracy Meter by one.
     */
    public void incGnomeCount() {
        addGnomeCount(1);
    }

    /**
     * Checks if the Conspiracy Meter is greater than the score threshold.
     *
     * @return if the game is over
     */
    public boolean isGameOver() {
        return gnomeCount >= MAX_GNOMES;
    }

    /**
     * Gets the Player who is winning the game.
     *
     * @return the player who is winning the game
     */
    public Player winner() {
        int maxGnomes = players.get(0).numGnomes();
        Player curWinner = players.get(0);
        for (Player p : players) {
            if (p.numGnomes() > maxGnomes) {
                curWinner = p;
                maxGnomes = curWinner.numGnomes();
            }
        }
        return curWinner;
    }

    /**
     * Start of the program.
     *
     * @param args Command-line arguments.
     */
    public static void main(String ... args) {
        PlasterClash game = new PlasterClash();
        Scanner scan = new Scanner(System.in);
        while (!game.isGameOver()) {
            Player cur = game.currentPlayer();
            System.out.println("=========================================");
            System.out.println("           " + cur + "'s Turn:");
            System.out.println("=========================================");
            System.out.println("Cards remaining in Tree: "
                 + cur.getTree().size());
            System.out.println("Total Gnomes: " + cur.numGnomes());
            boolean playing = true;
            System.out.println();
            System.out.println("--------------------------");
            System.out.println("       Play Stage");
            System.out.println("--------------------------");
            while (cur.hasHand() && playing) {
                System.out.println("Hand: ");
                System.out.println(cur.getHand());
                System.out.println("Enter the card # you would like to play,"
                        + " \"end\" to end, or \"all\" to play all.");
                System.out.print("> ");
                String blah = scan.nextLine().trim();
                if (blah.equals("end") || blah.equals("")) {
                    playing = false;
                } else if (blah.equals("all")) {
                    while (cur.hasHand()) {
                        Card c = cur.getHand().get(0);
                        c.play(game);
                    }
                } else {
                    try {
                        int idx = Integer.parseInt(blah);
                        cur.getHand().get(idx).play(game);
                    } catch (NumberFormatException | IndexOutOfBoundsException
                        e) {
                        System.out.println("This is not a valid entry.");
                    }
                }
                System.out.println();
            }

            System.out.println();

            boolean buying = true;
            int minCost = game.availableCards().stream()
                .mapToInt(c -> c.getCost()).min().orElse(Integer.MAX_VALUE);
            if (game.getKeebleCount() >= minCost) {
                System.out.println("--------------------------");
                System.out.println("       Buy Stage");
                System.out.println("--------------------------");
            } else {
                System.out.println("Not enough Keebles to buy anything.");
                System.out.println("Skipping Buy Stage.\n");
            }
            while (game.getKeebleCount() >= minCost && buying) {
                System.out.println("Number of keebles: "
                        + game.getKeebleCount());
                ArrayList<Card> available = game.availableCards();
                minCost = available.stream().mapToInt(c -> c.getCost())
                    .min().orElse(Integer.MAX_VALUE);
                System.out.println("Available cards:");
                for (int i = 0; i < available.size(); i++) {
                    System.out.println(i + ": " + available.get(i));
                }
                System.out.println();
                System.out.println("Enter what card you would like to buy,"
                        + " or \"end\" to end turn.");
                System.out.print("> ");
                String ans = scan.nextLine().trim();
                if (!ans.equals("end") && !ans.equals("")) {
                    try {
                        int numAns = Integer.parseInt(ans);
                        game.buyCardFromfield(available.get(numAns));
                    } catch (NumberFormatException | IndexOutOfBoundsException
                         e) {
                        System.out.println("This is not a valid entry.");
                    } catch (RuntimeException e) {
                        System.out.println("That card is too expensive.");
                    }
                } else {
                    buying = false;
                }
                System.out.println();
            }
            System.out.println("Discarding hand...");
            System.out.println("\n");
            game.endTurn();
            cur.endPlayerTurn();
        }
        System.out.println("=========================");
        System.out.println("|    WINNER: " + game.winner() + "   |");
        System.out.println("=========================");
        System.out.println();
        System.out.println("Number of gnomes: " + game.winner().numGnomes());
        System.out.println();
        System.out.println("Thanks for playing!");
    }
}
