import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Brennan Duffy
 * 10/29/2022
 */
public class ArrayProcessing {
    private int[] intArray;
    Scanner scanner;

    /**
     * Constructor for ArrayProcessing class
     */
    public ArrayProcessing() {
        intArray = new int[5];
        scanner = new Scanner(System.in);

        getNumbers();
        processNumbers();
    }

    // Run the program!
    public static void main(String[] args) {
        new ArrayProcessing();
    }

    /**
     * Populates the intArray with user input
     */
    private void getNumbers() {
        for (int i = 0; i < intArray.length; i++) {
            System.out.printf("Give me an int (%d of %d): ", i + 1, intArray.length);
            intArray[i] = getIntFromTerminal();
        }
        System.out.println("Numbers collected!");
    }

    private void processNumbers() {
        boolean hasntQuit = true;
        while (hasntQuit) {
            int command = printMenu(); // error checking for input is done in the menu itself
            switch (command) {
                case 1 -> add();
                case 2 -> mult();
                case 3 -> print();
                case 4 -> reverse();
                // no default needed (⌐▨_▨)
            }
            hasntQuit = again();
        }
    }

    /**
     * Prints a menu and gets a command code from the user
     * @return The command code received (1-4)
     */
    private int printMenu() {
        System.out.println("""
                Choose an option to perform:
                1) Add numbers
                2) Multiply numbers
                3) Print numbers
                4) Print number in reverse""");

        int input = getIntFromTerminal();
        while (input < 1 || input > 4) {
            System.out.println("Number given not a valid option, please try again.");
            input = getIntFromTerminal();
        }

        return input;
    }

    /**
     * Adds numbers in intArray and prints the result
     */
    private void add() {
        int sum = 0;
        // using an enhanced loop for conciseness
        for (int num : intArray) {
            sum += num;
        }
        System.out.println("Total sum: " + sum);
    }

    /**
     * Multiplies numbers in intArray and prints the result
     */
    private void mult() {
        int product = 1;
        // again, enhanced loop
        for (int num : intArray) {
            product *= num;
        }
        System.out.println("Total product: " + product);
    }

    private void print() {
        System.out.println("Array contents: ");
        for (int num : intArray) {
            System.out.println("> " + num);
        }
    }

    private void reverse() {
        System.out.println("Array contents (reversed): ");
        // easier to do with a traditional for loop
        for (int i = intArray.length; i > 0; i--) {
            System.out.println("> " + intArray[i - 1]);
        }
    }

    private boolean again() {
        System.out.println("Enter '1' to continue to '2' to quit.");
        int input = getIntFromTerminal();
        while (input < 1 || input > 2) {
            System.out.println("Number given not a valid option, please try again.");
            input = getIntFromTerminal();
        }
        return input == 1;
    }


    /**
     * Utility method to retrieve integer input from user
     * @return int value that was given by the user
     */
    private int getIntFromTerminal() {
        while(true) {
            String input = scanner.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}
