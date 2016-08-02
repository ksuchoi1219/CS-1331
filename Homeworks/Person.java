/**
 * This class represents Person.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class Person {

    protected String firstName;
    protected String lastName;
    protected String userName;
/** This is the Person constructor.
* @param firstName is the first name of the person.
* @param lastName is the last name of the person.
* @param userName is the user name of the perosn.
*/
    public Person(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
/** This is th getter for first name.
* @return first name of the person.
*/
    public String getFirstName() {
        return firstName;
    }
/** This is th getter for last name.
* @return last name of the person.
*/
    public String getLastName() {
        return lastName;
    }
/** This is th getter for user name.
* @return user name of the person.
*/
    public String getUserName() {
        return userName;
    }
}