import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class driver extends Exception{

    public static void main(String[] args){
        Catalogue store1 = new Catalogue();
        Catalogue store2 = new Catalogue();


        Product socks1 = new Socks(19.99, 1, "" + "Blue");
        Product socks2 = new Socks(19.99, 5, "" + "Red");



        int filterType = 2;
        store1.setFilter(filterType);

        socks1.setStockCount(3);
        socks1.printAttributes();
        socks1.sell(1);
        socks1.sell(2);


        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        //LocalDateTime today = LocalDateTime.now();
        //System.out.println(dtf.format(today));//
        //LocalDateTime alsoToday = LocalDateTime.now();
        //System.out.println(dtf.format(alsoToday));//
        //System.out.println(today.compareTo(alsoToday));//
        //Date date = new Date();
        //System.out.println(date);
    }
}
