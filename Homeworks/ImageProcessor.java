/**
 * This class performs different functions to the pictures.
 * @author Kwang Su Choi
 * @version 13.31
 */
public class ImageProcessor {
    private Pic picture;
    /**
    * Takes in the picture and makes a copy of it for the following methods
    * @param picture user picture
    */
    public ImageProcessor(Pic picture) {
        this.picture = picture;
    }
    /**
    * adds increment to red, green, blue, and alpha pixels to the picture
    * @param increment number of how much user
    *wants to increment the pixels of a picture
    * @return modifiedImage image that has been modified by add method
    */
    public Pic add(int increment) {
        Pic modifiedImage = picture.deepCopy();
        int height = modifiedImage.getHeight();
        int width = modifiedImage.getWidth();
        int r, g, b, a;
        Pixel[][] pix = modifiedImage.getPixels();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel pixel = pix[i][j];
                r = pixel.getRed();
                g = pixel.getGreen();
                b = pixel.getBlue();
                a = pixel.getAlpha();
                pixel.setRed(r + increment);
                if (r + increment > 255) {
                    pixel.setRed(255);
                }
                if (r + increment < 0) {
                    pixel.setRed(0);
                }
                pixel.setGreen(g + increment);
                if (g + increment > 255) {
                    pixel.setGreen(255);
                }
                if (g + increment < 0) {
                    pixel.setGreen(0);
                }
                pixel.setBlue(b + increment);
                if (b + increment > 255) {
                    pixel.setBlue(255);
                }
                if (b + increment < 0) {
                    pixel.setBlue(0);
                }
                pixel.setAlpha(a + increment);
                if (a + increment > 255) {
                    pixel.setAlpha(255);
                }
                if (a + increment < 0) {
                    pixel.setAlpha(0);
                }
            }
        }
        return modifiedImage;
    }
    /**
    * multiplies pixels in a given photo by scale.
    * @param scale double scale of how much pixles should be multiplied
    * @return modified image that has been scaled up
    *to the scale that the user has put in.
    */
    public Pic multiply(double scale) {
        Pic modifiedImage = picture.deepCopy();
        int height = modifiedImage.getHeight();
        int width = modifiedImage.getWidth();
        int r, g, b, a;
        double mr, mg, mb, ma;
        int intr, intg, intb, inta;
        Pixel[][] pix = modifiedImage.getPixels();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel pixel = pix[i][j];
                r = pixel.getRed();
                g = pixel.getGreen();
                b = pixel.getBlue();
                a = pixel.getAlpha();
                mr = r * scale;
                mg = g * scale;
                mb = b * scale;
                ma = a * scale;
                if (mr > 255) {
                    intr = 255;
                    intg = (int) mg;
                    intb = (int) mb;
                    inta = (int) ma;
                    pixel.setRed(intr);
                    pixel.setGreen(intg);
                    pixel.setBlue(intb);
                    pixel.setAlpha(inta);
                }
                if (mg > 255) {
                    intr = (int) mr;
                    intg = 255;
                    intb = (int) mb;
                    inta = (int) ma;
                    pixel.setRed(intr);
                    pixel.setGreen(intg);
                    pixel.setBlue(intb);
                    pixel.setAlpha(inta);
                }
                if (mb > 255) {
                    intr = (int) mr;
                    intg = (int) mg;
                    intb = 255;
                    inta = (int) ma;
                    pixel.setRed(intr);
                    pixel.setGreen(intg);
                    pixel.setBlue(intb);
                    pixel.setAlpha(inta);
                }
                if (ma > 255) {
                    intr = (int) mr;
                    intg = (int) mg;
                    intb = (int) mb;
                    inta = 255;
                    pixel.setRed(intr);
                    pixel.setGreen(intg);
                    pixel.setBlue(intb);
                    pixel.setAlpha(inta);
                }
            }
        }
        return modifiedImage;
    }
    /**
    * Chroma method takes in parameters and find the specific pixels
    *according to the conditional statements provided in this method.
    * in the picture and set their alpha values to 0.
    * @param key is the set of pixel values in Pixel class.
    * @param dr is delta red value which is given (20).
    * @param dg is delta green value which is given (40).
    * @param db is delta blue value which is given (20).
    * @return modified image that has its alpha vaules
    *changed to 0 according to the conditionals.
    */
    public Pic chroma(Pixel key, int dr, int dg, int db) {
        Pic modifiedImage = picture.deepCopy();
        int height = modifiedImage.getHeight();
        int width = modifiedImage.getWidth();
        int r, g, b, a;
        Pixel[][] pix = modifiedImage.getPixels();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel pixel = pix[i][j];
                r = pixel.getRed();
                g = pixel.getGreen();
                b = pixel.getBlue();
                a = pixel.getAlpha();
                if (Math.abs(r - key.getRed()) < dr
                    && Math.abs(g - key.getGreen()) < dg
                    && Math.abs(b - key.getBlue()) < db) {
                    pixel.setAlpha(0);
                }
            }
        }
        return modifiedImage;
    }
    /**
    * Background method replaces the specific pixel of the
    *picture with pixels of the background pixels.
    * @param bg is the background image that is Pic class.
    * @return modified image that has its background
    *image replaced by the new image.
    */
    public Pic background(Pic bg) {
        Pic modifiedImage = picture.deepCopy();
        int height = modifiedImage.getHeight();
        int width = modifiedImage.getWidth();
        int a;
        Pixel[][] pix = modifiedImage.getPixels();
        Pic bgImage = bg.deepCopy();
        int bgheight = bgImage.getHeight();
        int bgwidth = bgImage.getWidth();
        Pixel[][] bgpix = bgImage.getPixels();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Pixel pixel = pix[i][j];
                Pixel bgPixel = bgpix[i][j];
                a = pixel.getAlpha();
                if (a == 0) {
                    pixel.setRed(bgPixel.getRed());
                    pixel.setGreen(bgPixel.getGreen());
                    pixel.setBlue(bgPixel.getBlue());
                    pixel.setAlpha(bgPixel.getAlpha());
                }
            }
        }
        return modifiedImage;
    }
}