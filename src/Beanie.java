
public class Beanie extends Product{
    ProductCategory category = ProductCategory.Beanie;

    public Beanie(){
        this.price = 0;
        this.numberInStock = 1;
    }

    public Beanie(double price, int stockCount, String color){
        this.price = price;
        this.numberInStock = stockCount;
        this.color = color;
    }
}
