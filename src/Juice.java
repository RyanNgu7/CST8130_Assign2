/**
 * CET - CS Academic Level 3
 * Student Name: Ryan Nguyen
 * Student Number: 041137485
 * Section #: 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
import java.util.Scanner;

/**
 * This class represents a juice item record to be stored in an inventory manager.
 */
public class Juice extends FoodItem {
	/**
	 * Indicates whether or not the juice is organic.
	 */
	private boolean organic;
	
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * After the user fills in the common data member fields,
	 * the user is prompted to enter whether or not the juice is organic.
	 * Loops until the user enters a valid answer.
	 * </p>
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields.
	 */
    public String toString() {
    	return super.toString() + " organic: " + organic;
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * After the user fills in the common data member fields,
	 * the user is prompted to fill in the organic data member field.
	 * Loops until the user enters a positive integer.
	 * </p>
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields.
	 */
    public boolean addItem(Scanner scanner) {
    	super.addItem(scanner);												// Prompt user to fill in default data member fields
    	
    	// Get organic
		boolean validData = false;											// Flag that indicates whether or not the data is valid
		while (validData == false) {										// Loop until user enters valid data
			try {
				System.out.print("Is the juice organic (y/n)? ");			// Display prompt to user
				String answer = scanner.nextLine();							// Take in user input
				
				switch(answer) {					
					case "y":												// Set organic to true if user answers "y"
						organic = true;
						break;
					case "n":												// Set organic to false if user answers "n"
						organic = false;
						break;
					default:												// Throw exception if user inputs invalid answer
						throw new IllegalArgumentException();
				}
				
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (IllegalArgumentException iae) {
				System.out.println("Invalid entry");						// Display error message
			}
		}
    	return true;
    }
}
