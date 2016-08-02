/**
 * Item class represents an item, having name, weight, price, and barcode.
 * @author Alex Epifano & Thomas Shields
 * @version 1.0
 */
public class Item {

    private String name;
    private double weight;
    private double price;
    private long barcode;

    /**
     * Creates a new item with the specified weight and barcode. Initializes
     * name as null and price as 0.0.
     * @param  weight  The weight in grams of the item.
     * @param  barcode The barcode of the item.
     */
    public Item(double weight, long barcode) {
        this.weight = weight;
        this.barcode = barcode;
    }

    /**
     * Create new item with the specified properties.
     * @param  name    The name of the item.
     * @param  weight  The weight of the item in grams.
     * @param  price   The price of the item in USD.
     * @param  barcode The barcode of the item.
     */
    public Item(String name, double weight, double price, long barcode) {
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.barcode = barcode;
    }
    /** This is the getPrice method that returns price of the item.
    * @return price is the price of the item.
    */
    public double getPrice() {
        return this.price;
    }
    /** This is the equals method that determines if the two items are equal.
    * @param other is the other item that is being compared.
    * @return boolean true or false according to the method.
    */
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof Item)) {
            return false;
        }
        Item that = (Item) other;
        return (this.weight == that.weight && this.barcode == that.barcode);
    }
    /** This is the hashCode metod that prevents me from having checkstyl error.
    * @return 0 for compile.
    */
    public int hashCode() {
        return 0;
    }
}
