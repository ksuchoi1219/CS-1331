/**
 * This class is the test code for homework 4.
 * @author Kwang Su Choi
 * @version 13.31
 */


public class Processor {
/** This is the main method that tests all the cases for homework 4.
* @param args takes in no argument since this is the test code.
*/
    public static void main(String[] args) {

        GradStudent grad = new GradStudent("Aaron", "Smith", "asmith1");
        Professor prof = new Professor("Chris", "Simpkins", "csmith1");
        TA headTA = new TA("Thomas", "Shields", "tshields1");
        TA[] tas = {new TA("0", "b", "ab1"),
            new TA("1", "d", "cd1"),
            new TA("2", "f", "ef1"),
            new TA("3", "f", "ef1"),
            new TA("4", "f", "ef1"),
            new TA("5", "f", "ef1"),
            new TA("6", "f", "ef1"),
            new TA("7", "f", "ef1"),
            new TA("8", "f", "ef1"),
            new TA("9", "f", "ef1"),
            new TA("10", "f", "ef1"),
            new TA("11", "f", "ef1"),
            new TA("12", "f", "ef1"),
            new TA("13", "f", "ef1")};
            // new TA("15", "f", "ef1"),
            // new TA("16", "f", "ef1")};
        Student[] students = {new Student("John", "Smith", "jsmith1"),
            new Student("Danielle", "Kim", "dkim1")};
        Student newStudent =
            new Student("Kwang Su", "Choi", "kchoi67");

        // //Testing Person Class
        // Person person = new Person("Kwang Su", "Choi", "kchoi67");
        // System.out.println(person.getFirstName());
        // System.out.println(person.getLastName());
        // System.out.println(person.getUserName());

        // //Testing Professor Class
        // prof.setGPA(4.0);
        // System.out.println(prof.getGPA());
        // prof.setFunnyFactor(2.0);
        // System.out.println(prof.getFunnyFactor());

        // //Testing Student Class
        // students[0].study(5);
        // students[0].relax(10);
        // System.out.println(students[0].getStudyHours());
        // System.out.println(students[0].getNonStudyHours());
        // System.out.println(students[0].getFirstName());
        // System.out.println(students[0].getLastName());
        // System.out.println(students[0].getStudyPercentage());

        // students[1].study(5);
        // students[1].relax(10);
        // System.out.println(students[1].getStudyHours());
        // System.out.println(students[1].getNonStudyHours());
        // System.out.println(students[1].getFirstName());
        // System.out.println(students[1].getLastName());
        // System.out.printf("%1$.2f", students[1].getStudyPercentage());

        // // Testing UndergradStudent Class
        // newStudent.eatPizza(5);
        // newStudent.loseHope(20);
        // System.out.println(newStudent.getPizza());
        // System.out.println(newStudent.getHope());

        // //Testing GradStudent Class
        // grad.study(10);
        // grad.relax(10);
        // System.out.println(grad.getNonStudyHours());
        // System.out.println(grad.getStudyPercentage());

        // //Testing TA Class
        // headTA.setPiazzaScore(0.5);
        // headTA.setRecitationScore(0.5);
        // headTA.setOfficeHoursScore(2);
        // System.out.println(headTA.getPiazzaScore());
        // System.out.println(headTA.getRecitationScore());
        // System.out.println(headTA.getOfficeHoursScore());

        // //Testing Course Class
        // Course course = new Course("cs 1331", prof, headTA, tas, students);
        // System.out.println(course.getTitle());
        // System.out.println(course.getProfessor().getFirstName());
        // System.out.println(course.getHeadTA().getFirstName());
        // for (TA ta: course.getTAs()) {
        //     if (ta != null) {
        //         System.out.println(ta.getFirstName());
        //     }
        // }
        // course.addStudent(newStudent);
        // for (Student studs: course.getStudents()) {
        //     if (studs != null) {
        //         System.out.println(studs.getFirstName());
        //     }
        // }
        // System.out.println(course.getAverageStudyPercentage());
    }
}