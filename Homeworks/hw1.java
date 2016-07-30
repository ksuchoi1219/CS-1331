import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class GpaCalc {

    static void processInput() throws Exception {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the semester: (Ex. Fall 2014) ");
        String semester = userInput.nextLine();
        String nospace = semester.replaceAll("\\s+", "");
        String output = nospace.toLowerCase() + ".txt";
        FileWriter fWriter = null;
        BufferedWriter bWriter = null;
        fWriter = new FileWriter(output, false);
        bWriter = new BufferedWriter(fWriter);
        bWriter.write(semester);
        bWriter.newLine();
        int credit = 0;
        int grade = 0;
        int totalNumerator = 0;
        int totalCredit = 0;
        int totalGrade = 0;
        int combinedGradeAndCredit = 0;
        boolean process = true;
        while (process) {
            System.out.print("Enter the course title: (Ex. CS 1331) ");
            String course = userInput.nextLine();
            System.out.print("Enter the number of credits: ");
            credit = userInput.nextInt();
            System.out.print("Enter the grade: (Ex. A = 4, B = 3, etc.) ");
            grade = userInput.nextInt();
            System.out.print("Would you like to enter another course? (y/n) ");
            String answer = userInput.next();
            userInput.nextLine();
            combinedGradeAndCredit = grade * credit;
            totalGrade += combinedGradeAndCredit;
            totalCredit += credit;
            totalNumerator = totalGrade * totalCredit;
            if (answer.equals("y")) {
                FileWriter fWriter1 = null;
                BufferedWriter bWriter1 = null;
                fWriter1 = new FileWriter(output, true);
                bWriter1 = new BufferedWriter(fWriter1);
                bWriter1.write(course.toUpperCase() + " - "
                    + String.valueOf(credit)
                    + " credits. " + "Grade: " + String.valueOf(grade));
                bWriter1.newLine();
                bWriter1.close();
            } else if (answer.equals("n")) {
                double gpa = (totalGrade * 1.0 / totalCredit);
                System.out.println("Overall GPA: "
                    + String.format("%.2f", gpa));
                FileWriter fWriter2 = null;
                BufferedWriter bWriter2 = null;
                fWriter2 = new FileWriter(output, true);
                bWriter2 = new BufferedWriter(fWriter2);
                bWriter2.write(course.toUpperCase() + " - "
                    + String.valueOf(credit)
                    + " credits. " + "Grade: " + String.valueOf(grade));
                bWriter2.newLine();
                bWriter2.write("GPA: " + String.format("%.2f", gpa));
                bWriter2.close();
                process = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        boolean process = true;
        int totalNumerator = 0;
        int totalCredit = 0;
        processInput();
        while (process) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Would you like to calculate "
                + "for another semester? (y/n) ");
            String anotherSemester = userInput.nextLine();
            if (anotherSemester.equals("y")) {
                totalNumerator = 0;
                totalCredit = 0;
                processInput();
            } else if (anotherSemester.equals("n")) {
                process = false;
            }
        }
    }
}