import java.io.IOException;

/**
 * This class eexecutes Photoslop.java.
 * @author Kwang Su Choi
 * @version 13.31
 */

public class Photoslop {
    /** this is the main method of Photoslop class.
    * @param args is the name of the image name.
    */
    public static void main(String... args) throws IOException {
        if (args.length < 4) {
            printUsage();
            System.exit(0);
        }
        try {
            String imageName = args[1];
            Pic picture = new Pic(imageName);
            ImageProcessor image = new ImageProcessor(picture);
            //your code here
            //hint the base pic for use with the image processor is in args[1]

            if (args[0].equals("-a")) {
                int increment = Integer.parseInt(args[2]);
                image.add(increment).save(args[3]);

                //add mode
                //your code here
                //add args[2] to the picture, then call
                //Save to args[3]
            } else if (args[0].equals("-m")) {
                int scale = Integer.parseInt(args[2]);
                image.multiply(scale).save(args[3]);
                //same as add, but multiply
            } else if (args[0].equals("-c")) {
                //use this as your chroma key to match
                //the greenscreen in the lego guy image
                Pixel chromaKey = new Pixel(26, 185, 19, 1);
                Pic bg = new Pic(args[2]);
                Pic temp = image.chroma(chromaKey, 20, 40, 20);
                ImageProcessor bgImage = new ImageProcessor(temp);
                bgImage.background(bg).save(args[3]);

                //Your code here to apply the chroma key transformation
                //It's up to you what you want the
                //rgb deltas (thresholds) to be,
                //I used something like 20, 40, 20
                //Hint: to do this part, consider making another ImageProcessor
                //Your code here to apply the background (args[2])
                //Finally, save to args[3]
            } else {
                printUsage();
            }
        } catch (IOException ex) {
            System.out.println("One of the files you referenced does not exist,"
                + " or is corrupted. Double-check and try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Add mode: ");
        System.out.println("java -a imageFile n outputFile");
        System.out.println("");
        System.out.println("Multiply mode: ");
        System.out.println("java -m imageFile n outputFile");
        System.out.println("");
        System.out.println("Greenscreen mode: ");
        System.out.println("java -c imageFile backgroundFile outputFile");
    }
}
