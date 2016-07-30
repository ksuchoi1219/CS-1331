import java.util.Scanner;
import java.io.File;

public class GradeHistogram {

    public static void main(String[] args) throws Exception {

        Scanner inputFile = new Scanner(new File(args[0]));
        System.out.println("Grades loaded!");
        int bucketSize;
        String bucketSizeString;
        if (args.length < 2) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("What bucket size would you like?");
            bucketSize = userInput.nextInt();
        } else {
            bucketSizeString = args[1];
            bucketSize = Integer.parseInt(bucketSizeString);
        }
        int arraySize = 100 / bucketSize + 1;
        int [] grades = new int [arraySize];
        while (inputFile.hasNext()) {
            if (inputFile.hasNextInt()) {
                int grade = inputFile.nextInt();
                for (int i = 100, j = grades.length - 1;
                    i >= 0; i -= bucketSize, j--) {
                    if (grade <= i && (grade >= (i - bucketSize + 1))) {
                        grades[j]++;
                    }
                }
            } else {
                inputFile.next();
            }
        }
        for (int i = 100, j = grades.length - 1; i >= 0; i -= bucketSize, j--) {
            if ((i - bucketSize + 1) >= 0) {
                System.out.printf("%3d - %3d | ", i, i - bucketSize + 1);
                for (int k = grades[j]; k > 0; k--) {
                    System.out.print("[]");
                }
                System.out.println();
            } else {
                System.out.printf("%3d -   0 | ", i);
                for (int k = grades[j]; k > 0; k--) {
                    System.out.print("[]");
                }
                System.out.println();
            }
        }
    }

}