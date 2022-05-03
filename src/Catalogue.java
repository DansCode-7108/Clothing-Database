import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Catalogue{

    private final String name;
    private final HashMap<Integer, String> filter = new HashMap<>();
    private final HashSet<Product> ProductMap = new HashSet<>();
    private final LinkedList PriceList, AlphaOrderList, DateList;

    /**
     * Constructor
     */
    public Catalogue(String str){
        this.name = str;
        filter.put(0, "Price: LowToHigh");
        filter.put(1, "Price: HighToLow");
        filter.put(2, "Date: Earlier");
        filter.put(3, "Date: Later");

        this.AlphaOrderList = new LinkedList();
        this.PriceList = new LinkedList();
        this.DateList = new LinkedList();
    }

    public void filterItems(int type){
        if (!filter.containsKey(type)) {
            System.out.println("Invalid Filter Type: " + type);
            return;
        }

        System.out.println("Filter Type: " + filter.get(type));
        switch(type){
            case(0):{ showLowToHigh();}
            case(1):{ showHighToLow();}
            case(2):{ showEarlyDate();}
            case(3):{ showLaterDate();}
        }
    }

    public void fill(int num){
        HashMap<Integer, String> colors = new HashMap<>();
        colors.put(0, "Purple");
        colors.put(1, "Blue");
        colors.put(2, "Green");
        colors.put(3, "Yellow");
        colors.put(4, "Orange");
        colors.put(5, "Red");

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
        PriceList.insertEnd(p);
        ProductMap.add(p);
    }

    public void remove(Product p){
        if (!ProductMap.contains(p)) return;
        ProductMap.remove(p);
        AlphaOrderList.remove(p);
        PriceList.remove(p);
        DateList.remove(p);
    }

    public Product get(Product p){
        if (ProductMap.contains(p)) return p;
        return null;
    }

    public void showLowToHigh(){
        System.out.println("Showing Price from Low to High \n");
        PriceList.printFromHead();
    }

    public void showHighToLow(){
        System.out.println("Showing Price from High to Low \n");
        PriceList.printFromLast();
    }

    public void showEarlyDate(){
        System.out.println("Showing Date from Earliest to Latest \n");

    }

    public void showLaterDate(){
        System.out.println("Showing Date from Latest to Earliest \n");
    }

    public void sortAll(){
        this.AlphaOrderList.sortList();
        this.PriceList.sortList();
        this.DateList.sortList();
    }
}
