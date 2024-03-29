/**
 * Jersey Class
 * Subclass of Product
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Jersey extends Product {
    ProductCategory category = ProductCategory.Jersey;

    /**
     * Default Jersey Constructor
     * Sets the default attributes for Jersey objects
     */
    public Jersey(){
        this.price = 0;
        this.numberInStock = 1;
        this.status = ProductStatus.InStock;
    }

    /**
     * Jersey Constructor
     * Sets custom attributes for Jersey objects
     * @param price
     * Price of item
     * @param stockCount
     * Quantity of item in inventory
     * @param color
     * Color of item
     */
    public Jersey(String name, double price, int stockCount, String color){
        this.productName = name;
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }



}
