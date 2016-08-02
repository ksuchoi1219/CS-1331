/**
 * This class represents Graduate student which extends to Student class.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class GradStudent extends Student {

/** This is the GradStudent constructor.
* @param firstName is the first name of the graduate student.
* @param lastName is the last name of the graduate student.
* @param userName is the user name of the graduate student.
*/

    public GradStudent(String firstName, String lastName,
        String userName) {
        super(firstName, lastName, userName);

    }
/** This is the getter for study hours.
* @return studyHours is the hours that are spent studying.
*/
    public int getStudyHours() {
        return studyHours;
    }
/** This is the getter for non study hours.
* @return nonStudyHours is the hours that are spent not studying.
*/
    public int getNonStudyHours() {
        return nonStudyHours;
    }
/** This is the getter for study percentage.
* @return 100.0 is the percentage that is spent for studying.
*/
    public double getStudyPercentage() {
        return 100.0;
    }
/** This is the setter for study hours.
* @param hours is the hours that are spent studying.
*/
    public void study(int hours) {
        studyHours = studyHours + hours;
    }
/** This is the setter for non study hours.
* @param hours is the hours that are spent not studying.
*/
    public void relax(int hours) {
        nonStudyHours = 0;
    }
}