/**
 * This class represents Course.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class Course {

    private String title;
    private Professor professor;
    private TA headTA;
    private TA[] tas = new TA[15];
    private Student[] students = new Student[300];
/** This is the course constructor.
* @param title is the title of the course.
* @param professor is the Professor class.
* @param headTA is the TA class.
* @param tas is the TA class in array.
* @param students is the Student class in array.
*/
    public Course(String title, Professor professor,
        TA headTA, TA[] tas, Student[] students) {
        this.title = title;
        this.professor = professor;
        this.headTA = headTA;
        for (int i = 0; i < tas.length; i++) {
            this.tas[i] = tas[i];
        }
        for (int i = 0; i < students.length; i++) {
            this.students[i] = students[i];
        }
    }
/** This is the getter for title of the course.
* @return title is the title of the course.
*/
    public String getTitle() {
        return title;
    }
/** This is the getter for methods in Professor class.
* @return professor is Professor class.
*/
    public Professor getProfessor() {
        return professor;
    }
/** This is the getter for head TA from TA class.
* @return headTA is the head TA from TA class.
*/
    public TA getHeadTA() {
        return headTA;
    }
/** This is the getter for all the TAs in tas array.
* @return tas is the tas from tas array.
*/
    public TA[] getTAs() {
        return tas;
    }
/** This is the getter for all the students in the students array.
* @return students is the students from students array.
*/
    public Student[] getStudents() {
        return students;
    }
/** This is the getter for average study percentage
of students in students array.
* @return average is the average study hours percentage
from students in students array.
*/
    public double getAverageStudyPercentage() {
        double sum = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                sum += students[i].getStudyPercentage();
            }
        }
        double average = sum / students.length;
        return average;
    }
/** This is adding a student into the students array.
* @param s is the student class new student.
*/
    public void addStudent(Student s) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = s;
                i = students.length;
            }
        }
    }
}