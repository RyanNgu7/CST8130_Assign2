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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents a vegetable item record to be stored in an inventory manager system.
 */
public class Vegetable extends FoodItem {
    /**
     * The name of the farm supplier of the item.
     */
	private String farmName;
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * After the user fills in the common data member fields,
	 * the user is prompted to enter the name of the farm supplier.
	 * Loops until the user enters a positive integer.
	 * </p>
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields.
	 */
    public String toString() {
    	return super.toString() + " farm suppllier: " + farmName;
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * After the user fills in the common data member fields,
	 * the user is prompted to enter the farm supplier of the product.
	 * </p>
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields.
	 */
    public boolean addItem(Scanner scanner, boolean fromFile) {
    	super.addItem(scanner, fromFile);											// Prompt user to input default data member fields
    		
    	// Get farmName
		boolean validData = false;													// Flag that indicates whether or not the data is valid
		while (validData == false) {												// Loop until the user inputs valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the name of the farm supplier: ");		// Display prompt
				}
				farmName = scanner.nextLine();										// Take in user input
				
				validData = true;													// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (Exception e) {
				System.out.println("Invalid entry");								// Display error message
			}
		}
    	return true;
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * Also writes v to signify the item is a vegetable and
	 * the farm name.
	 * </p>
	 * 
	 * @param writer The FileWriter used to write to a file.
	 * @throws IOException
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write("v\n");				// Writes "v" to signify this item is a vegetable
    	super.outputItem(writer);			// Write the data members that are common to all FoodItem objects
    	writer.write(farmName + "\n");		// Write the farm name to the file.
	}
}
