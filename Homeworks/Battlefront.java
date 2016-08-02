import java.util.Scanner;
/**
* This class represents Battlefront class which initiates the simulation.
* @author Kwang Su Choi
* @version 1.0
*/

public class Battlefront {
    /** This is the main method which executes the simulation program.
    * @param args is the argument for the class.
    */
    public static void main(String[] args) {
        RebelHero rebelHero = new RebelHero(100, 20, 40, "12");
        TrooperHero trooperHero = new TrooperHero(100, 20, 40, "34");
        System.out.println("Welcome to the Battlefront1331 Simulator!");
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many Rebel Soldiers"
            + " would you like to include?");
        int rsNum = Integer.parseInt(userInput.nextLine());
        System.out.println("How many Jedi would you like to include?");
        int jediNum = Integer.parseInt(userInput.nextLine());
        System.out.println("How many Stormtroopers would you like to include?");
        int stNum = Integer.parseInt(userInput.nextLine());
        System.out.println("How many Sith would you like to include?");
        int sithNum = Integer.parseInt(userInput.nextLine());
        Simulation simulation = new Simulation(rsNum, jediNum,
            stNum, sithNum, rebelHero, trooperHero);
        System.out.println("Press enter to begin the simulation");
        while (simulation.simulateSkirmish(false)) {
            System.out.println("Press enter to continue the simulation");
            userInput.nextLine();
        }
        if (simulation.getNumTroopersRemaining() == 0
            || simulation.getNumRebellionRemaining() == 0) {
            System.out.println("Simulation Complete!");
            System.out.println(simulation.getNumRebellionRemaining()
                + " of " + rsNum + " Rebel Soldiers remain!");
            System.out.println(simulation.getNumJediRemaining()
                + " of " + jediNum + " Jedi remain!");
            System.out.println(simulation.getNumTroopersRemaining()
                + " of " + stNum + " Stormtroopers remain!");
            System.out.println(simulation.getNumSithRemaining()
                + " of " + sithNum + " Sith remain!");
        }
    }
}