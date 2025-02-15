/**
 * CET - CS Academic Level 3
 * Student Name: Ryan Nguyen
 * Student Number: 041137485
 * Section #: 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class represents food item records to be stored in an inventory manager.
 */
public class FoodItem implements Comparable<FoodItem> {
	/**
	 * The item code of the record.
	 */
	private int itemCode;
	/**
	 * The item name of the record.
	 */
	private String itemName;
	/**
	 * The quantity of the item currently in stock.
	 */
	private int itemQuantityInStock;
	/**
	 * The price the produce stand pays for the item.
	 */
	private float itemCost;
	/**
	 * The sales price that the customers pay for the item
	 */
	private float itemPrice;

	@Override
	/**
	 * Return all data members in the class. Rounds price and cost to 2 decimal places.
	 */
	public String toString() {
		return "Item: " + itemCode + " " + itemName + " " + itemQuantityInStock +
				" price: $" + String.format("%.2f", itemPrice) +
				" cost: $" + String.format("%.2f", itemCost);
	}
	
	@Override
	public int compareTo(FoodItem foodItem) {
		return this.itemCode - foodItem.itemCode;
	}
	
	/**
	 * Updates an item's quantity in stock.
	 * Ensures that stock does not go below 0.
	 * 
	 * @param amount The amount to add or subtract from stock.
	 * @return true if the stock was successfully updated, and false if unsuccessful.
	 */
	public boolean updateItem(int amount) {
		if (itemQuantityInStock + amount < 0) {								// If the amount would cause the stock to drop below 0:
			System.out.println("Insufficient stock in inventory...");		// Display error message
			return false;
		} else {															// If the amount is valid:
			itemQuantityInStock += amount;									// update stock
			return true;
		}		
	}
	
	/**
	 * Prompts the user to fill in data member fields for a new item:
	 * code, name, quantity, cost, price.
	 * For each data member, loop until user enters a valid value.
	 * 
	 * @param fromFile Indicates whether or not the scanner is reading from a file.
	 * @param scanner A Scanner object used to read in user input.
	 * @return true if the program successfully reads in all fields, otherwise returns false
	 */
	public boolean addItem(Scanner scanner, boolean fromFile) {
		boolean validData = false;											// Flag that indicates whether or not the user input data is valid
			
		// Get itemName
		while (validData == false) {										// Loop until user inputs valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the name for the item: ");			// Display prompt
				}
				itemName = scanner.nextLine();								// Read in user input
				
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (Exception e) {
				System.out.println("Invalid entry");						// Display error message
				scanner.nextLine();											// Clear scanner buffer
			}
		}
		
		// Get itemQuantity
		validData = false;													// Reset flag to false
		while (validData == false) {										// Loop until user inputs valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the quantity for the item: ");		// Display prompt
				}
				itemQuantityInStock = scanner.nextInt();					// Take in user input
				scanner.nextLine();											// Clear \n
				
				if (itemQuantityInStock <= 0) {								// Throw exception if user inputs non-positive integer
					throw new IllegalArgumentException();
				}
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (InputMismatchException ime) {							// Catch non-integer values
				System.out.println("Invalid entry");						// Display error message
				scanner.nextLine();											// Clear scanner buffer
			} catch (IllegalArgumentException iae) {						// Catch non-positive integers
				System.out.println("Invalid entry");						// Display error message
			}
		}
		
		// Get itemCost from user
		validData = false;													// Reset flag
		while (validData == false) {										// Loop until user enters valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the cost of the item: ");			// Display prompt to user
				}
				itemCost = scanner.nextFloat();								// Read in user input
				scanner.nextLine();											// Clear scanner buffer
				
				if (itemCost <= 0) {										// Throw exception if user inputs non-positve integer
					throw new IllegalArgumentException();
				}
				
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (InputMismatchException ime) {							// Catches non-float values
				System.out.println("Invalid entry");						// Display error message
				scanner.nextLine();											// Clear scanner buffer
			} catch (IllegalArgumentException iae) {						// Catches non-positive float values
				System.out.println("Invalid entry");						// Display error message
			}
		}
		
		// Get itemPrice from user
		validData = false;													// Reset flag
		while (validData == false) {										// Loop until user enters valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the sales price of the item: ");	// Display prompt to user
				}
				itemPrice = scanner.nextFloat();							// Read in user input
				scanner.nextLine();											// Clear scanner buffer
				
				if (itemPrice <= 0) {										// Throw exception if user inputs non-positve integer
					throw new IllegalArgumentException();
				}
				
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (InputMismatchException ime) {							// Catches non-float values
				System.out.println("Invalid entry");						// Display error message
				scanner.nextLine();											// Clear scanner buffer
			} catch (IllegalArgumentException iae) {						// Catches non-positive float values
				System.out.println("Invalid entry");						// Display error message
			}
		}		
		return true;
	}
	/**
	 * Compares the item code of the object this method is acting upon to a new item code.
	 * Return true if the codes are the same. Return false if they are different.
	 * @param newItem A potential new item to be added to the inventory.
	 * @return true if the item codes match. Return false otherwise.
	 */
	public boolean isEqual(FoodItem newItem) {
		return (newItem.itemCode == this.itemCode);
	}
	
	/**
	 * Prompts user to input an item code.
	 * Loop until the user inputs an integer.
	 * 
	 * @param scanner A scanner object used to read in user input.
	 * @param fromFile Indicates whether or not the scanner is reading from a file.
	 * @return true if successful.
	 */
	public boolean inputCode(Scanner scanner, boolean fromFile){
		boolean validData = false;											// Flag that indicates if the user-input data is valid
		
		// Get itemCode
		while (validData == false) {										// Loop until user inputs valid data
			try {
				if (fromFile == false) {
					System.out.print("Enter the code for the item: ");		// Display prompt to user
				}
				itemCode = scanner.nextInt();								// Take in user input
				scanner.nextLine();											// Clear \n from buffer
				
				validData = true;											// If this code is reached, valid data has been successfully input and we can exit the loop
			} catch (Exception e) {					
				System.out.println("Invalid code");							// Display error message
				scanner.nextLine();											// Clear scanner buffer
			}
		}
		return true;
	}
	/**
	 * Writes a FoodItem's default data to a file.
	 * 
	 * @param writer The FileWriter object used to write to a given file.
	 * @throws IOException When an error occurs while writing to a file.
	 */
	public void outputItem(FileWriter writer) throws IOException {
		writer.write(itemCode + "\n" +
					itemName + "\n" +
					itemQuantityInStock + "\n" +
					itemCost + "\n" +
					itemPrice + "\n");	
	}

	/**
	 * @return the itemCode
	 */
	public int getItemCode() {
		return itemCode;
	}
}
