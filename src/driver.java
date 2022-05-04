
import java.util.*;

/**
 * driver Class used to run and test the Catalogue Program
 * Authors: Dan Lorenzo, Matthew Sirois, Sebastian Arreola
 */
public class driver{
    public final static Scanner scan = new Scanner(System.in);
    public final static InputMismatchException StringInputException = new InputMismatchException();

    /**
     * yesNoInput() method used to check "yes" and "no" user inputs
     * @return
     * Returns a boolean value: They represent the two possible user inputs.
     * @throws InputMismatchException
     * Throws the InputMismatchException StringInputException if the input is not recognized.
     */
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

    /**
     * setQuantity() method used to take an integer input from the user.
     * @return
     * Returns an integer input if it is within the designated range.
     * @throws InputMismatchException
     * Throws and catches the InputMismatchException if input is not an integer.
     */
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

    /**
     * main method
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        String textInput;
        boolean ExitStatus = false;

        // While loop probes for user input, controlling the flow of the program
        while (!ExitStatus) {
            try {
                System.out.println("Would you Like to Create a New Catalogue? (yes/no)");
                textInput = scan.nextLine();

                // Forces user to input string with the correct format
                while (!textInput.equals("yes") && !textInput.equals("no")){
                    System.out.println("Please Enter \"yes\" or \"no\"");
                    textInput = scan.nextLine();
                }

                if (textInput.equals("yes")) {
                    // Initiates the creation of a new catalogue
                    System.out.println("What is this Catalogue's Name?");
                    textInput = scan.nextLine();
                    Catalogue cat = new Catalogue(textInput);   // Catalogue object instantiation

                    System.out.println("Should we Initialize this Catalogue with Products? (yes/no)");
                    if (yesNoInput()){
                        // Begins population of catalogue with Product type objects
                        System.out.println("How Many Items Should it be Initialized with?");
                        System.out.println("Enter a Number between 0 and 10000");
                        cat.fill(setQuantity());    // Checks for valid quantity and populates catalogue
                        cat.sortAll();  // Sorts all unsorted product storage methods
                        cat.showLowToHigh();    // Displays products from low to high price
                        cat.showHighToLow();    // Displays products from high to low price

                    }

                } else {
                    ExitStatus = true;  // Ends program execution
                }

            }
            // Catches any InputMismatchException
            catch (InputMismatchException StringInputException) {
                System.out.println("Please Enter \"yes\" or \"no\"");
            }
        }
    }
}
