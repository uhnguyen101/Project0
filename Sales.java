// Midterm - Sales.java
// UyenNghi Nguyen

import java.util.*; // scanner
import java.io.*; // file libraries, exceptions

/**
 * This is a program that creates a file and allows users
 * to read, write, and compute values.
 *
 * @author  UyenNghi Nguyen
 * @version 1.0
 * @since   2022-01-31
 */

public class Sales {
    public static void main(String[] args) throws Exception // throws all exceptions
    {
        Scanner input = new Scanner(System.in); // scanner for user input
        boolean quit = false; // bool to check if user wants to quit program

        while (!quit)
        {
            System.out.println("Please choose one of the following options by typing in the corresponding number:");
            System.out.println("1 - Add a sale to our sales file.");
            System.out.println("2 - Print out all the sales in our file.");
            System.out.println("3 - Print the total of all sales.");
            System.out.println("4 - Quit the program.");

            int userInput = input.nextInt();

            if (userInput == 1)
            {
                System.out.println("Please enter a double value for the sale.");
                double addSale = input.nextDouble();
                FileWriter appendFile = new FileWriter("sales.txt", true); // create a text file to append to
                PrintWriter outputFile = new PrintWriter(appendFile); // create the output to write to
                outputFile.println(addSale); // adds in user inputted double value
                outputFile.close(); // closes the file
                System.out.println(); // extra line just to make it look nicer when outputted
            }
            else if (userInput == 2)
            {
                Scanner file = new Scanner(new File ("sales.txt"));
                while (file.hasNextLine()) // while there are sales in our sales.txt file
                {
                    System.out.println(file.nextLine()); // will print out each line (each double)
                }
                System.out.println(); // extra line just to make it look nicer when outputted
            }
            else if (userInput == 3)
            {
                double sum = 0.0; // sum double to keep track of the value
                double sales; // variable for sales (as double)
                Scanner file = new Scanner(new File ("sales.txt"));
                while (file.hasNextDouble()) // while there are sales in our sales.txt file
                {
                    sales = file.nextDouble(); // sales = the next value in our file
                    sum += sales; // continuously add sales to our sum
                }
                System.out.println("The total sales is " + sum + ".");
                System.out.println(); // extra line just to make it look nicer when outputted
            }
            else if (userInput == 4)
            {
                quit = true; // this will break the loop and quit the program
            }
            else
            {
                System.out.println("Please choose a valid option."); // if user does not enter 1-4
                System.out.println(); // extra line just to make it look nicer when outputted
            }
        }
        System.out.println("You have quit the program.");
    }
}
