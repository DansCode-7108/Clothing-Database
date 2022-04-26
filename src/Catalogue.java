import java.util.Map;
import java.util.Collection;
public class Catalogue {

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
        } else {
            System.out.println("Invalid Filter Type: " + type);
        }
    }

    public void remove(Product p){

    }

    public Product get(Product p){

        return p;
    }
}
