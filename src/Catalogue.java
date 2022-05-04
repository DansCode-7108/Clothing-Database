import java.util.HashMap;
import java.util.Random;

/**
 * Catalogue Class
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class Catalogue{

    private final String name;
    private final Random gen = new Random();
    private final HashMap<String, Product> ProductMap = new HashMap<>();
    private final HashMap<Integer, String> colors = new HashMap<>();
    private final LinkedList PriceList, AlphaOrderList, DateList;

    /**
     * Catalogue Constructor
     * @param str
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

    /**
     *
     * @param num
     */
    public void fill(int num){
        for(int i = 0; i < num; i++){
            String name = ("Socks" + i);
            double price = ((double) gen.nextInt(2000))/100;
            String color = colors.get(gen.nextInt(6));
            Product socks = new Socks(name, price, 1, color);
            System.out.println(socks);
            this.add(socks.productName, socks);
            //System.out.println(ProductMap.get(socks.productName));
        }
    }

    /**
     *
     * @return
     */
    public String getName(){
        return this.name;
    }

    /**
     *
     * @param name
     * @param p
     */
    public void add(String name, Product p){
        this.PriceList.insertEnd(p);
        this.ProductMap.put(name, p);
    }

    /**
     *
     * @param p
     */
    public void remove(Product p){
        if (!ProductMap.containsKey(p.productName)) return;
        ProductMap.remove(p.productName);
        AlphaOrderList.remove(p);
        PriceList.remove(p);
        DateList.remove(p);
    }

    /**
     *
     * @param name
     * @return
     */
    public Product get(String name){
        return ProductMap.get(name);
    }

    /**
     *
     */
    public void showLowToHigh(){
        System.out.println("Showing Price from Low to High \n");
        this.PriceList.printFromHead();
    }

    /**
     *
     */
    public void showHighToLow(){
        System.out.println("Showing Price from High to Low \n");
        PriceList.printFromLast();
    }

    /**
     *
     */
    public void showEarlyDate(){
        System.out.println("Showing Date from Earliest to Latest \n");

    }

    /**
     *
     */
    public void showLaterDate(){
        System.out.println("Showing Date from Latest to Earliest \n");
    }

    /**
     *
     */
    public void sortAll(){
        AlphaOrderList.sortByPrice();
        PriceList.sortByPrice();
        DateList.sortByPrice();
    }
}
