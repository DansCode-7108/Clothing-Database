/**
 * Beanie Class
 * Subclass of Product
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Beanie extends Product{
    ProductCategory category = ProductCategory.Beanie;

    /**
     * Default Beanie Constructor
     * Sets the default attributes for Beanie objects
     */
    public Beanie(){
        this.price = 0;
        this.numberInStock = 1;
        this.status = ProductStatus.InStock;
    }

    /**
     * Beanie Constructor
     * Sets custom parameters for Beanie objects
     * @param price
     * Price of item
     * @param stockCount
     * Quantity of item in inventory
     * @param color
     * Color of item
     */
    public Beanie(String name, double price, int stockCount, String color){
        this.productName = name;
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }
}
