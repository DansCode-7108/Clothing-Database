/**
 * Coat Class
 * Subclass of Product
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Coat extends Product{
    ProductCategory category = ProductCategory.Coat;

    /**
     * Default Coat Constructor
     * Sets the default attributes for Coat objects
     */
    public Coat(){
        this.price = 0;
        this.numberInStock = 1;
        this.status = ProductStatus.InStock;
    }

    /**
     * Coat Constructor
     * Sets custom attributes for Coat objects
     * @param price
     * Price of item
     * @param stockCount
     * Quantity of item in inventory
     * @param color
     * Color of item
     */
    public Coat(String name, double price, int stockCount, String color){
        this.productName = name;
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }

}
