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
 * This class represents a preserve item record to be stored in an inventory manager.
 */
public class Preserve extends FoodItem {
    /**
     * The size of the jar in millilitres.
     */
	private int jarSize;
    
    @Override
    /**
     * {@inheritDoc}
     * <p>
     * Also returns the size in millilitres.
     * </p>
     */
    public String toString() {
    	return super.toString() + " size: " + jarSize + "mL";
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * After the user fills in the common data member fields,
	 * the user is prompted to enter the size of the jar in millilitres.
	 * Loops until the user enters a positive integer.
	 * </p>
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields.
	 */
    public boolean addItem(Scanner scanner, boolean fromFile) {
    	super.addItem(scanner, fromFile);												// Prompt user to fill in default data member fields
    	
    	// Get size in millilitres
		boolean validData = false;														// Flag that indicates whether or not the data is valid
		while (validData == false) {													// loop until the data is valid
			try {
				if (fromFile == false) {
					System.out.print("Enter the size of the jar in millilitres: ");		// Display prompt to user
				}
				jarSize = scanner.nextInt();											// Take in user input
				scanner.nextLine();														// Clear "\n" from buffer
				
				if (jarSize <= 0) {														// Throw exception if user enters non-positive integer
					throw new IllegalArgumentException();
				}
				validData = true;														// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (InputMismatchException ime) {										// Handles non-integer values
				System.out.println("Invalid entry");									// Display error message
				scanner.nextLine();														// Clear scanner buffer
			} catch (IllegalArgumentException iae) {									// Handles non-positive integers
				System.out.println("Invalid entry");									// Display error message
			}
		}
    	return true;
    }
    
    @Override
    /**
	 * {@inheritDoc}
	 * <p>
	 * Also writes p to signify the item is a preserve and
	 * the jar size.
	 * </p>
	 * 
	 * @param writer The FileWriter used to write to a file.
	 * @throws IOException
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write("p\n");			// Write p to signify the item is a preserve
    	super.outputItem(writer);		// Write the data members common to all FoodItem objects
    	writer.write(jarSize + "\n");	// Write the jar size to the file
	}
}