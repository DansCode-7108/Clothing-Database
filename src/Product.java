
import java.util.Date;

/**
 *
 */

public class Product {
    public double price;
    public String color;
    public int numberInStock;
    public String productName;
    public Date listingDate;

    /**
     *
     */
    protected enum ProductCategory{
        Coat,
        Jersey,
        Socks,
        Beanie
    }

    /**
     *
     */
    public enum ProductStatus{
        InStock,
        OutOfStock
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price){
        this.price = price;
    }

    /**
     *
     * @return
     */
    public double getPrice(){
        return this.price;
    }

    /**
     *
     * @param stockCount
     */
    public void setStockCount(int stockCount) {
        numberInStock = stockCount;
        if (numberInStock < 1) {
            ProductStatus status = ProductStatus.OutOfStock;
        } else {
            ProductStatus status = ProductStatus.InStock;
        }
    }

    /**
     *
     * @return
     */
    public int getStockCount(){
        return this.numberInStock;
    }

    /**
     *
     */
    private void decrementStock(int count){
        numberInStock -= count;
        if (numberInStock < 1) {
            ProductStatus status = ProductStatus.OutOfStock;
        } else {
            ProductStatus status = ProductStatus.InStock;
        }
    }

    /**
     *
     */
    public String toString(){
        return ("Item Name: " + this.productName
                + "\nItem Price: $" + String.format("%,.02f", this.price)
                + "\nItem Color: " + this.color
                + "\nNumber in Stock: " + this.numberInStock
                + "\nItem Listing Date: " + this.listingDate);
    }

    /**
     *
     * @param quantity
     */
    public void sell(int... quantity){
        if (quantity[0] >= this.numberInStock) {
            this.decrementStock(quantity[0]);
            System.out.println("There are now " + this.numberInStock + " items left in stock.");
        } else {
            System.out.println("Please select a smaller quantity.");
        }
    }

    //public String generateItemID(){
    //    String ID = "";
    //
    //    return ID;
    //}

    //public void storeItemID(int itemID){
    //
    //}

}
