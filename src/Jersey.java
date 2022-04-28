
public class Jersey extends Product {
    ProductCategory category = ProductCategory.Jersey;

    public Jersey(){
        this.price = 0;
        this.numberInStock = 1;
    }

    public Jersey(double price, int stockCount, String color){
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }



}
