
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;


public class driver extends Exception{

    public static void main(String[] args){
        Catalogue store1 = new Catalogue();
        Catalogue store2 = new Catalogue();


        Product socks1 = new Socks(19.99, 1, "" + "Blue");
        Product socks2 = new Socks(19.99, 5, "" + "Red");


        HashMap<Integer, String> colors = new HashMap<>();
        colors.put(0, "Purple");
        colors.put(1, "Blue");
        colors.put(2, "Green");
        colors.put(3, "Yellow");
        colors.put(4, "Orange");
        colors.put(5, "Red");

        Random gen = new Random();

        for(int i = 0; i < 100; i++){
            double price = ((double) gen.nextInt(2000))/100;
            String color = colors.get(gen.nextInt(6));
            Product socks = new Socks(price, 1, color);
            store1.add(socks);
        }

        store1.filterItems(0);
        store1.sortAll();
        store1.showLowtoHigh();


        //int filterType = 0;
        //store1.setFilter(filterType);

        //store1.add(socks1);

        //socks1.setStockCount(3);
        //socks1.toString();
        //socks1.sell(1);
        //socks1.sell(2);


        //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        //LocalDateTime today = LocalDateTime.now();
        //System.out.println(dtf.format(today));//
        //LocalDateTime alsoToday = LocalDateTime.now();
        //System.out.println(dtf.format(alsoToday));//
        //System.out.println(today.compareTo(alsoToday));//
        //Date date = new Date();
        //System.out.println(date);




        //System.out.println("Linked list: ");
        //list.printList();

        //System.out.println("After deleting: ");
        //list.delete(3);
        //list.printList();

        //list.sortList(list.head);
        //System.out.println("\nSorted List: ");
        //list.printList();
    }
}
