/**
 * This class represents Undergraduate student which extends to Student class.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class UndergradStudent extends Student {

    private int hope = 100;
    private int pizza = 0;
/** This is the UndergradStudent constructor.
* @param firstName is the first name of the undergraduate student.
* @param lastName is the last name of the undergraduate student.
* @param userName is the user name of the undergraduate student.
*/
    public UndergradStudent(String firstName, String lastName,
        String userName) {
        super(firstName, lastName, userName);
        this.hope = hope;
        this.pizza = pizza;
    }
/** This is the setter for pizza.
* @param pizzas are the number of pizzas that are eaten by student.
*/
    public void eatPizza(int pizzas) {
        pizza = pizza + pizzas;
    }
/** This is the seter for hope.
* @param hopeLoss is the number of hope that
are going to be subtracted from total hope.
*/
    public void loseHope(int hopeLoss) {
        hope = hope - hopeLoss;
    }
/** This is the getter for pizza number.
* @return pizza is the number of pizza that are eaten by student.
*/
    public int getPizza() {
        return pizza;
    }
/** This is the getter for hope.
* @return hope is the number of hope that is left after hopeLoss is subtracted.
*/
    public int getHope() {
        return hope;
    }
}