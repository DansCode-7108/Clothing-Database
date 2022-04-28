import java.util.Map;
import java.util.Collections;

public class Catalogue{

    /**
     * Constructor
     */
    public Catalogue(){

    }


    private static Map<Integer, String> filter = Map.of(
        0, "Alphabetical Order: AtoZ",
            1, "Alphabetical Order: ZtoA",
            2, "Price: LowtoHigh",
            3, "Price: HightoLow",
            4, "Date: Earlier",
            5, "Date: Later"
    );

    //public enum filter{
    //    AtoZ,
    //    ZtoA,
    //    LowtoHigh,
    //    HightoLow;
    //}

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
            case(0): sortAtoZ();
            case(1): sortZtoA();
            case(2): sortLowtoHigh();
            case(3): sortHightoLow();
            case(4): sortEarlyDate();
            case(5): sortLaterDate();
        }
    }

    public void remove(Product p){

    }

    public Product get(Product p){

        return p;
    }

    //Linked List?
    public void sortAtoZ(){
        System.out.println("Sorted AtoZ");
    }

    //Linked List?
    public void sortZtoA(){
        System.out.println("Sorted ZtoA");

    }

    public void sortLowtoHigh(){
        System.out.println("Sorted Low to High");

    }

    public void sortHightoLow(){
        System.out.println("Sorted High to Low");

    }

    public void sortEarlyDate(){
        System.out.println("Sorted from Earliest to Latest");

    }

    public void sortLaterDate(){
        System.out.println("Sorted from Latest to Earlier");
    }
}
