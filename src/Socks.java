
public class Socks extends Product {
    ProductCategory category = ProductCategory.Socks;

    public Socks(){
        this.price = 0;
        this.numberInStock = 1;
    }

    public Socks(double price, int stockCount, String color){
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }

}
