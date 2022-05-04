
import java.util.Date;

/**
 * Product Class
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Product {
    public double price;
    public String color;
    public int numberInStock;
    public String productName;
    public Date listingDate;
    public ProductStatus status;

    /**
     * ProductCategory
     * Used to identify objects of each subclass
     */
    protected enum ProductCategory{
        Coat,
        Jersey,
        Socks,
        Beanie
    }

    /**
     * ProductStatus
     */
    public enum ProductStatus{
        InStock,
        OutOfStock
    }

    /**
     * setPrice() method
     * Set the price of an item
     * @param price
     * Price to be assigned
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     * getPrice() method
     * @return
     * Returns the price of an item
     */
    public double getPrice(){
        return this.price;
    }

    /**
     * setStockCount() method
     * @param stockCount
     * Stock count to be assigned
     */
    public void setStockCount(int stockCount) {
        numberInStock = stockCount;
        if (numberInStock < 1) {
            this.status = ProductStatus.OutOfStock;
        } else {
            this.status = ProductStatus.InStock;
        }
    }

    /**
     * getStockCount() method
     * @return
     * Returns the current stock count of an item
     */
    public int getStockCount(){
        return this.numberInStock;
    }

    /**
     * decrementStock() method
     * Decreases the stock count of a particular item
     * @param count
     * Number of times to decrement the stock count
     */
    private void decrementStock(int count){
        numberInStock -= count;
        if (numberInStock < 1) {
            this.status = ProductStatus.OutOfStock;
        } else {
            this.status = ProductStatus.InStock;
        }
    }

    /**
     * toString() method
     * @return
     * Returns the String format of an item for printing
     */
    public String toString(){
        return ("Item Name: " + this.productName
                + "\nItem Price: $" + String.format("%,.02f", this.price)
                + "\nItem Color: " + this.color
                + "\nNumber in Stock: " + this.numberInStock
                + "\nItem Listing Date: " + this.listingDate);
    }

    /**
     * sell() method
     * Used when a user wants to purchase an item
     * @param quantity
     * Number of a particular item to be sold
     */
    public void sell(int quantity){
        if (quantity >= this.numberInStock) {
            this.decrementStock(quantity);
            System.out.println("There are now " + this.numberInStock + " items left in stock.");
        } else {
            System.out.println("Please select a smaller quantity.");
        }
    }
}
