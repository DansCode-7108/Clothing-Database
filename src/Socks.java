/**
 * Socks Class
 * Subclass of Product
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Socks extends Product {
    ProductCategory category = ProductCategory.Socks;

    /**
     * Default Socks Constructor
     * Sets default attributes of Socks object
     */
    public Socks(){
        this.price = 0;
        this.numberInStock = 1;
        this.status = ProductStatus.InStock;
    }

    /**
     * Socks Constructor
     * Sets custom attributes for a Socks object
     * @param price
     * Price of item
     * @param stockCount
     * Quantity of item in inventory
     * @param color
     * Color of item
     */
    public Socks(String name, double price, int stockCount, String color){
        this.productName = name;
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }
}
