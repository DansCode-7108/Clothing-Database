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

    public void filterItems(int type){
        if (!filter.containsKey(type)) {
            System.out.println("Invalid Filter Type: " + type);
            return;
        }

        System.out.println("Filter Type: " + filter.get(type));
        switch(type){
            case(0):{ showLowtoHigh();}
            case(1):{ showHightoLow();}
            case(2):{ showEarlyDate();}
            case(3):{ showLaterDate();}
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
        System.out.println("Showing Price from Low to High \n");
        PriceList.printFromHead();
    }

    public void showHightoLow(){
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
        PriceList.sortList();
    }
}
