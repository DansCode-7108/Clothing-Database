import java.util.Map;

public class driver extends Exception{

    public static void main(String[] args){
        Catalogue store1 = new Catalogue();

        Product socks1 = new Socks(20, 1, "blue");

        int filterType = 2;
        store1.setFilter(filterType);

        socks1.printAttributes();
    }
}
