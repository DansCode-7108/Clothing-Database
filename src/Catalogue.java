import java.util.HashMap;

public class Catalogue{

    private HashMap<Integer, String> filter = new HashMap<>();
    private LinkedList PriceList;

    /**
     * Constructor
     */
    public Catalogue(){
        filter.put(0, "Price: LowtoHigh");
        filter.put(1, "Price: HightoLow");
        filter.put(2, "Date: Earlier");
        filter.put(3, "Date: Later");

        PriceList = new LinkedList();

    }


    public void setFilter(int type){
        if (filter.containsKey(type)) {
            System.out.println("Filter Type: " + filter.get(type));
            filterItems(type);
        } else {
            System.out.println("Invalid Filter Type: " + type);
        }
    }

    public void filterItems(int type){
        switch(type){
            case(0): showLowtoHigh();
            case(1): showHightoLow();
            case(2): showEarlyDate();
            case(3): showLaterDate();
        }
    }

    public void add(Product p){
        PriceList.insertEnd(p);
    }

    public void remove(Product p){

    }

    public Product get(Product p){

        return p;
    }


    public void showLowtoHigh(){
        System.out.println("Showing Price from Low to High");

    }

    public void showHightoLow(){
        System.out.println("Showing Price from High to Low");

    }

    public void showEarlyDate(){
        System.out.println("Showing Date from Earliest to Latest");

    }

    public void showLaterDate(){
        System.out.println("Showing Date from Latest to Earliest");
    }
}
