import java.util.Date;

public class Product {
    public double price;
    public String color;
    public int numberInStock;
    public String productName;
    public Date listingDate;

    protected enum ProductCategory{
        Coat,
        Jersey,
        Socks,
        Beanie
    }

    public enum ProductStatus{
        InStock,
        OutOfStock
    }

    public void setPrice(double price){
        this.price = price;
    }

    public double getPrice(){
        return this.price;
    }

    public void setStockCount(int stockCount) {
        numberInStock = stockCount;
        if (numberInStock < 1) {
            ProductStatus status = ProductStatus.OutOfStock;
        } else {
            ProductStatus status = ProductStatus.InStock;
        }
    }

    public int getStockCount(){
        return this.numberInStock;
    }
    
    protected void decrementStock(){
        numberInStock -= 1;
        if (numberInStock < 1) {
            ProductStatus status = ProductStatus.OutOfStock;
        } else {
            ProductStatus status = ProductStatus.InStock;
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
