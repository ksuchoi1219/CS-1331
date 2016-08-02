/**
 * This class represents Student which extends to Person class.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class Student extends Person {
    protected int studyHours = 0;
    protected int nonStudyHours = 0;
/** This is the Student constructor
* @param firstName is the first name of the student.
* @param lastName is the last name of the student.
* @param userName is the user name of the student.
*/
    public Student(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
    }
/** This is the setter for study hours.
* @param hours is the hours that are spent studying.
*/
    public void study(int hours) {
        studyHours = studyHours + hours;
    }
/** This is the setter for relax hours.
* @param hours is the hours that are spent not studying.
*/
    public void relax(int hours) {
        nonStudyHours = nonStudyHours + hours;
    }
/** This is the getter for study percentage.
* @return studyPercentage is the percentage that
is spent studying over total hours.
*/
    public double getStudyPercentage() {
        if (studyHours + nonStudyHours != 0) {
            double studyPercentage = ((double) (studyHours)
                / (studyHours + nonStudyHours)) * 100;

            return studyPercentage;
        } else {
            return 0;
        }
    }
/** This is the getter for study hours.
* @return studyHours is the hours that are spent studying.
*/
    public int getStudyHours() {
        return studyHours;
    }
/** This is the getter for relax hours.
* @return nonStudyHours is the hours that are spent not studying.
*/
    public int getNonStudyHours() {
        return nonStudyHours;
    }
}