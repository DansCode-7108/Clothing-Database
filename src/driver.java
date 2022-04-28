import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Date;

public class driver extends Exception{

    public static void main(String[] args){
        Catalogue store1 = new Catalogue();
        Catalogue store2 = new Catalogue();


        Product socks1 = new Socks(19.99, 1, "" + "Blue");
        Product socks2 = new Socks(19.99, 5, "" + "Red");



        int filterType = 0;
        store1.setFilter(filterType);

        store1.add(socks1);

        socks1.setStockCount(3);
        socks1.toString();
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

        LinkedList list = new LinkedList();

        list.insertEnd(1);
        list.insertBeginning(2);
        list.insertBeginning(3);
        list.insertEnd(4);
        list.insert(list.head.next, 5);

        System.out.println("Linked list: ");
        list.printList();

        System.out.println("After deleting: ");
        list.delete(3);
        list.printList();

        list.sortList(list.head);
        System.out.println("\nSorted List: ");
        list.printList();
    }
}
