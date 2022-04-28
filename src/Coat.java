
public class Coat extends Product{
    ProductCategory category = ProductCategory.Coat;
    public Coat(){
        this.price = 0;
        this.numberInStock = 1;
    }

    public Coat(double price, int stockCount, String color){
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }

}
