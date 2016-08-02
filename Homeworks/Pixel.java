/**
 * This class represents a Pixel object.
 * @author Kwang Su Choi
 * @version 13.31
 */
public class Pixel {
    private int red;
    private int green;
    private int blue;
    private int alpha;
    /**
    * Initializes Pixel values for red, green, blue, and alpha
    * @param red red pixel values
    * @param green green pixel valuse
    * @param blue blue pixel values
    * @param alpha alpha pixel values
    */
    public Pixel(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }
    /**
    * This method returns the value of red
    * @return red value
    */
    public int getRed() {
        return red;
    }
    /**
    * This method returns the value of green
    * @return green value
    */
    public int getGreen() {
        return green;
    }
    /**
    * This method returns the value of blue
    * @return blue value
    */
    public int getBlue() {
        return blue;
    }
    /**
    * This method returns the value of alpha
    * @return alpha value
    */
    public int getAlpha() {
        return alpha;
    }
    /**
    * This method takes a number value and returns
    *if the value is between 0 and 255
    * @param num number value
    * @return boolean true or false
    */
    public boolean acceptable(int num) {
        return num <= 255 && num >= 0;
    }
    /**
    * This method sets the red value according to the user input
    * @param red user red value
    */
    public void setRed(int red) {
        if (acceptable(red)) {
            this.red = red;
        }
    }
    /**
    * This method sets the green value according to the user input
    * @param green user green value
    */
    public void setGreen(int green) {
        if (acceptable(green)) {
            this.green = green;
        }
    }
    /**
    * This method sets the blue value according to the user input
    * @param blue user blue value
    */
    public void setBlue(int blue) {
        if (acceptable(blue)) {
            this.blue = blue;
        }
    }
    /**
    * This method sets the alpha value according to the user input
    * @param alpha user alpha value
    */
    public void setAlpha(int alpha) {
        if (acceptable(alpha)) {
            this.alpha = alpha;
        }
    }
}
