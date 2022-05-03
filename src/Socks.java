

public class Socks extends Product {
    ProductCategory category = ProductCategory.Socks;

    public Socks(){
        this.price = 0;
        this.numberInStock = 1;
    }

    public Socks(String name, double price, int stockCount, String color){
        this.productName = name;
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }

}
