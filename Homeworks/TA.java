/**
 * This class represents TA wich extentsto UndergradStdent class.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class TA extends UndergradStudent {


    private double piazzaScore;
    private double recitationScore;
    private double officeHoursScore;
/** This is the TA constructor.
* @param firstName is the first name of the ta.
* @param lastName is the last name of the ta.
* @param userName is the user name of the ta.
*/
    public TA(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
        this.piazzaScore = piazzaScore;
        this.recitationScore = recitationScore;
        this.officeHoursScore = officeHoursScore;
    }
/** This is the setter for pizza score of the ta.
* @param piazzaScore is the score for piazza for the ta.
*/
    public void setPiazzaScore(double piazzaScore) {
        if (piazzaScore <= 1 && piazzaScore >= 0) {
            this.piazzaScore = piazzaScore;
        }
    }
/** This is the setter for recitation score of the ta.
* @param recitationScore is the score for recitaion for the ta.
*/
    public void setRecitationScore(double recitationScore) {
        if (recitationScore <= 1 && recitationScore >= 0) {
            this.recitationScore = recitationScore;
        }
    }
/** This is the setter for office hours score of the ta.
* @param officeHoursScore is the score for office hours for the ta.
*/
    public void setOfficeHoursScore(double officeHoursScore) {
        if (officeHoursScore <= 1 && officeHoursScore >= 0) {
            this.officeHoursScore = officeHoursScore;
        }
    }
/** This is the getter for piazza score.
* @return piazzaScore is the piazza score of the ta between 0 and 1.
*/
    public double getPiazzaScore() {
        return piazzaScore;
    }
/** This is the getter for recitation score.
* @return recitationScore is the recitation score of the ta between 0 and 1.
*/
    public double getRecitationScore() {
        return recitationScore;
    }
/** This is the getter for office hours score.
* @return officeHoursScore is the office hours of the ta between 0 and 1.
*/
    public double getOfficeHoursScore() {
        return officeHoursScore;
    }
}