
import java.util.*;

public class driver{
    public final static Scanner scan = new Scanner(System.in);
    public final static InputMismatchException StringInputException = new InputMismatchException();

    public static boolean yesNoInput() throws InputMismatchException{
        String input = scan.nextLine();
        input = input.toLowerCase();
        if (input.equals("yes")) {
            return true;
        } else if (input.equals("no")){
            return false;
        } else {
            throw StringInputException;}
    }

    public static int setQuantity() throws InputMismatchException{
        try {
            int value = scan.nextInt();
            while (value < 1 || value > 10000) {
                System.out.println("Please Input an Integer between 1 and 10000");
                value = scan.nextInt();
            }
            return value;
        } catch(InputMismatchException exception){
            System.out.println("Please Enter an Integer between 1 and 10000");
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        String textInput;
        int numInput;
        boolean ExitStatus = false;

        while (!ExitStatus) {
            try {
                System.out.println("Would you Like to Create a New Catalogue? (yes/no)");
                textInput = scan.nextLine();

                while (!textInput.equals("yes") && !textInput.equals("no")){
                    System.out.println("Please Enter \"yes\" or \"no\"");
                    textInput = scan.nextLine();
                }

                if (textInput.equals("yes")) {
                    System.out.println("What is this Catalogue's Name?");
                    textInput = scan.nextLine();
                    Catalogue cat = new Catalogue(textInput);

                    System.out.println("Should we Initialize this Catalogue with Products? (yes/no)");
                    if (yesNoInput()){
                        System.out.println("How Many Items Should it be Initialized with?");
                        System.out.println("Enter a Number between 0 and 10000");
                        cat.fill(setQuantity());
                        cat.sortAll();
                        cat.showLowToHigh();
                        cat.showHighToLow();
                    }

                } else if (textInput.equals("no")){
                    ExitStatus = true;
                } else throw StringInputException;

                System.out.println("It gets here");
            }
            catch (InputMismatchException StringInputException) {
                System.out.println("Please Enter \"yes\" or \"no\"");
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
