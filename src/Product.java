import java.util.Date;

public class Product {
    public double price;
    public String color;
    public int numberInStock;
    public String productName;
    public Date listingDate;

    public enum ProductCategory{
        Coat,
        Jersey,
        Socks,
        Beanie;
    }

    public enum ProductStatus{
        InStock,
        OutOfStock;
    }


    public void setStockCount(int stockCount) {
        numberInStock = stockCount;
        if (stockCount < 1) {
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
