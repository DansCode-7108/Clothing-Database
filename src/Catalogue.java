import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Catalogue{

    private final String name;
    private final HashSet<Product> ProductMap = new HashSet<>();
    private final HashMap<Integer, String> colors = new HashMap<>();
    private final LinkedList PriceList, AlphaOrderList, DateList;

    /**
     * Constructor
     */
    public Catalogue(String str){
        this.name = str;
        colors.put(0, "Purple");
        colors.put(1, "Blue");
        colors.put(2, "Green");
        colors.put(3, "Yellow");
        colors.put(4, "Orange");
        colors.put(5, "Red");

        this.AlphaOrderList = new LinkedList();
        this.PriceList = new LinkedList();
        this.DateList = new LinkedList();
    }

    public void fill(int num){

        Random gen = new Random();

        for(int i = 0; i < 5; i++){
            double price = ((double) gen.nextInt(2000))/100;
            String color = colors.get(gen.nextInt(6));
            Product socks = new Socks(price, 1, color);
            //store1.add(socks);
        }

    }

    public String getName(){
        return this.name;
    }

    public void add(Product p){
        this.PriceList.insertEnd(p);
        this.ProductMap.add(p);
    }

    public void remove(Product p){
        if (!ProductMap.contains(p)) return;
        this.ProductMap.remove(p);
        this.AlphaOrderList.remove(p);
        this.PriceList.remove(p);
        this.DateList.remove(p);
    }

    public Product get(Product p){
        if (this.ProductMap.contains(p)) return p;
        return null;
    }

    public void showLowToHigh(){
        System.out.println("Showing Price from Low to High \n");
        this.PriceList.printFromHead();
    }

    public void showHighToLow(){
        System.out.println("Showing Price from High to Low \n");
        this.PriceList.printFromLast();
    }

    public void showEarlyDate(){
        System.out.println("Showing Date from Earliest to Latest \n");

    }

    public void showLaterDate(){
        System.out.println("Showing Date from Latest to Earliest \n");
    }

    public void sortAll(){
        this.AlphaOrderList.sortByPrice();
        this.PriceList.sortByPrice();
        this.DateList.sortByPrice();
    }
}
