/**
 * This class represents Professor which extends to Person class.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class Professor extends Person {

    private double funnyFactor;
    private double gpa;
/** This is the Professor constructor.
* @param firstName is the first name of the professor.
* @param lastName is the last name of the professor.
* @param userName is the user name of the professor.
*/
    public Professor(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
    }
/** This is the setter for gpa.
* @param thegpa is the double gpa value.
*/
    public void setGPA(double thegpa) {
        if (thegpa >= 0 && thegpa <= 4) {
            this.gpa = thegpa;
        } else {
            System.out.println("This value is not valid!");
        }
    }
/** This is the setter for funny factor.
* @param funnyFactor is the doble funny factor.
*/
    public void setFunnyFactor(double funnyFactor) {
        if (funnyFactor <= 0 && funnyFactor >= 1) {
            this.funnyFactor = funnyFactor;
        } else {
            System.out.println("This value is not valid!");
        }
    }
/** This is the getter for gpa.
* @return gpa is the gpa for course that the professor teaches.
*/
    public double getGPA() {
        return gpa;
    }
/** This is the gettre for funny factor.
* @return funnyFactor is the funy factor of the professor.
*/
    public double getFunnyFactor() {
        return funnyFactor;
    }

}