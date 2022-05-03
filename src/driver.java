
import java.util.*;

public class driver{
    public final static Scanner scan = new Scanner(System.in);
    public final static InputMismatchException StringInputException = new InputMismatchException("Please Input Text");

    public static boolean yesNoInput() throws InputMismatchException{
        String textInput = scan.nextLine();
        if (textInput.equals("yes")) {
            return true;
        } else if (textInput.equals("no")){
            return false;
        } else {
            throw StringInputException;}
    }

    public static void main(String[] args) throws InputMismatchException{
        String textInput;
        boolean ExitStatus = false;


        while (!ExitStatus) {
            try {
                System.out.println("Would you Like to Create a New Catalogue? (yes/no)");
                textInput = scan.nextLine().toLowerCase();

                if (textInput.equals("yes")) {
                    System.out.println("What is this Catalogue's Name?");
                    textInput = scan.nextLine();
                    Catalogue cat = new Catalogue(textInput);

                    System.out.println("Should we Initialize this Catalogue with Products? (yes/no)");
                    if (yesNoInput()){
                        cat.fill(scan.nextInt());
                    }

                } else if (textInput.equals("no")){
                    ExitStatus = true;
                } else throw StringInputException;

            } catch (InputMismatchException exception) {
                throw StringInputException;
            }
        }



        //store1.filterItems(0);
        //store1.sortAll();
        //store1.showLowToHigh();


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
