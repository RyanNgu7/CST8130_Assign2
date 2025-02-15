/**
 * CET - CS Academic Level 3
 * Student Name: Ryan Nguyen
 * Student Number: 041137485
 * Section #: 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class represents a fruit item record to be stored in an inventory manager.
 */
public class Fruit extends FoodItem {
	/**
	 * The orchard name that the fruit is from.
	 */
    private String orchardName;
    
    @Override
    /**
     * {@inheritDoc}
     * <p>
     * Also returns the orchard supplier of the fruit.
     * </p>
     */
    public String toString() {
    	return super.toString() + " orchard supplier: " + orchardName;
    }
    
    @Override
    /**
 	 * {@inheritDoc}
 	 * <p>
 	 * After the user fills in the common data member fields,
 	 * the user is prompted to enter the size of the name of the orchard supplier.
 	 * Loops until the user enters a positive integer.
 	 * </p>
 	 * 
 	 * @param scanner A scanner object used to read in user input.
 	 * @return true if the program successfully reads in all fields.
 	 */
    public boolean addItem(Scanner scanner, boolean fromFile) {
    	super.addItem(scanner, fromFile);																// Prompt user to fill in the data fields common to all foodItem types
    	
    	// Get orchardName
		boolean validData = false;															// Flag that indicates whether or not the user has input valid data
		while (validData == false) {														// Loop until the data is valid
			try {
				if (fromFile == false) {
					System.out.print("Enter the name of the orchard supplier: ");				// Display prompt to user
				}
				orchardName = scanner.nextLine();											// Take in user input
				
				validData = true;															// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (Exception e) {
				System.out.println("Invalid entry");										// Display error message
			}
		}
    	return true;
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * Also writes f to signify the item is a fruit and
	 * the orchard name.
	 * </p>
	 * 
	 * @param writer The FileWriter used to write to a file.
	 * @throws IOException
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write("f\n");					// Write f to signify this item is a fruit
    	super.outputItem(writer);				// Call the superclass
    	writer.write(orchardName + "\n");		// Write the fruit-specific data-member
	}
}