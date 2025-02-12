/**
 * CET - CS Academic Level 3
 * Student Name: Ryan Nguyen
 * Student Number: 041137485
 * Section #: 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class serves as the driver for the Inventory class.
 * It acts as an inventory system for a produce stand. The system stores the
 * item codes, names, quantities, costs, and sales prices of all items. The main menu
 * allows the user to create new item records, update quantities in stock and to display a
 * summary of all the items in inventory.
 */
public class Assign2 {
	/**
	 * Main method of the produce stand inventory.
	 * @param args
	 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);										// Instantiate Scanner object
        Inventory inventory = new Inventory();											// Instantiate Inventory object
        boolean successFlag = false;													// Flag that indicates the success of a method
        
        int option = 0;																	// Set option to a value that will start the loop							
        while (option != 5) {															// Loop until user decides to exit
            displayMenu();
            try {
                option = scanner.nextInt();												// Take in user input

                switch(option) {
                	// 1: Add Item to Inventory
                	case 1:                		
                		successFlag = inventory.addItem(scanner);
                		if (successFlag == false) {
                			System.out.println("Inventory at max capacity");
                		}
                		break;
                		
                	// 2: Display Current Inventory
                	case 2:
                		System.out.println("Inventory:");								// Display header
                		System.out.println(inventory.toString());   					// Display inventory summary             		
                		break;
                	
                	// 3: Buy Item(s)
                	case 3:
                		successFlag = inventory.updateQuantity(scanner, true);			// Attempt to buy items
                			
                		if (successFlag == false) {										// If buy was unsuccessful, display error message
                			System.out.println("Error...could not buy item");
                		}
                		break;
                		
                	// 4: Sell Item(s)
                	case 4:
                		successFlag = inventory.updateQuantity(scanner, false);			// Attempt to sell items
                		
                		if (successFlag == false) {										// If sell was unsuccessful, display error message
                			System.out.println("Error...could not sell item");
                		}
                		break;
                    // 5: Exit
                    case 5:
                        System.out.println("Exiting...");								// Display exit message
                        scanner.close();												// Close scanner instance
                        break;
                    default:
                        throw new InputMismatchException();								// Throw exception when a user enters a number that is not one of the options
                }

            } catch (InputMismatchException ime) {
                option = 0;                             								// Reset option to ensure loop continues
                scanner.nextLine();														// Clear scanner buffer
                System.out.println("Incorrect value entered");							// Display error message
            }
        }
    }
    /**
     * Display the main menu
     */
    public static void displayMenu() {
        System.out.print("Please select one of the following:\n" +
                        "1: Add Item to Inventory\n" +
                        "2: Display Current Inventory\n" +
                        "3: Buy Item(s)\n" +
                        "4: Sell Item(s)\n" +
                        "5: To Exit\n" +
                        "> ");
    }
}
