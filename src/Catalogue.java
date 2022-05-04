import java.util.HashMap;
import java.util.Random;

/**
 * Catalogue Class
 * The Catalogue object manages all products stored by the user.
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
     * Name of the catalogue.
     * This is for the user to reference through the UI.
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
     * fill() method
     * Fills the catalogue with a user-determined number of products.
     * This is mainly for testing purposes.
     * @param num
     * Number of products to be added.
     */
    public void fill(int num){
        for(int i = 0; i < num; i++){
            String name = ("Socks" + i);
            double price = ((double) gen.nextInt(2000))/100;
            String color = colors.get(gen.nextInt(6));
            Product socks = new Socks(name, price, 1, color);
            System.out.println(socks);
            this.add(socks.productName, socks);
        }
    }

    /**
     * getName() method
     * @return
     * Returns the name of the Catalogue object
     */
    public String getName(){
        return this.name;
    }

    /**
     * add() method
     * Adds the new product to every storage structure in its respective format.
     * This functions to keep all storage structures in sync with one another.
     * @param name
     * Name of the new product
     * @param p
     * Reference to the product
     */
    public void add(String name, Product p){
        this.PriceList.insertEnd(p);
        this.ProductMap.put(name, p);
    }

    /**
     * remove() method
     * Removes an existing product from all storage structures.
     * This functions to keep all storage structures in sync with one another.
     * @param p
     * Reference to the product to be removed
     */
    public void remove(Product p){
        if (!ProductMap.containsValue(p)) return;
        ProductMap.remove(p.productName);
        AlphaOrderList.remove(p);
        PriceList.remove(p);
        DateList.remove(p);
    }

    /**
     * get() method
     * Gets the details of a product stored in the catalogue
     * @param name
     * Name of the product
     * @return
     * Returns a product type object stored under the given key
     */
    public Product get(String name){
        return ProductMap.get(name);
    }

    /**
     * showLowtoHigh() method
     * Shows all products from the lowest price to the highest price
     */
    public void showLowToHigh(){
        System.out.println("Showing Price from Low to High \n");
        this.PriceList.printFromHead();
    }

    /**
     * showHighToLow() method
     * Shows all products from the highest price to the lowest price.
     */
    public void showHighToLow(){
        System.out.println("Showing Price from High to Low \n");
        PriceList.printFromLast();
    }

    /**
     * showEarlyDate() method
     * Shows all products from the earliest to latest to be added to the catalogue.
     */
    public void showEarlyDate(){
        System.out.println("Showing Date from Earliest to Latest \n");

    }

    /**
     * showLaterDate() method
     * Shows all products from the latest to earliest to be added to the catalogue.
     */
    public void showLaterDate(){
        System.out.println("Showing Date from Latest to Earliest \n");
    }

    /**
     * sortAll() method
     * Sorts all storage structures with their respective criteria
     */
    public void sortAll(){
        PriceList.sortByPrice();
    }
}
