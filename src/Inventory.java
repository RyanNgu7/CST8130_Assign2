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
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * This class contains methods to create, store, and update food item records. Validates user input.
 * Ensures the inventory does not go past max capacity
 */
public class Inventory {
    /**
     * An array that stores the FoodItem objects.
     */
	private ArrayList<FoodItem> inventory = new ArrayList<FoodItem>();
	/**
	 * A counter for the number of FoodItem records in inventory
	 */
    private int numItems;
    /**
     * The maximum number of records the inventory manager can hold.
     */
    private static final int MAX_INVENTORY = 20;

    @Override
    /**
     * Displays a summary of all food items in inventory
     */
    public String toString() {
    	String output= "";
    	
    	if (numItems > 0) {													// First checks if there are any items in inventory to avoid NullPointerException
	    	for (int i = 0; i < numItems; i++) {							// Iterate through all FoodItem objects in inventory
	    		output += inventory.get(i).toString() + "\n";				// Add toString output from each object to final output
	    	}
    	}
    	return output;
    }
    
    /**
     * Checks whether or not a FoodItem record already exists in the inventory.
     * 
     * @param newItem A FoodItem object to be potentially added to the inventory
     * @return the index of the item if it already exists in inventory. Return -1 if the food item does not exist in inventory.
     */
    public int alreadyExists(FoodItem newItem) {    	
    	
    	
    	for (FoodItem itemFromInventory : inventory) {				// Iterate through all items in inventory
    		if (itemFromInventory.isEqual(newItem)) {				// Compare item in inventory to passed in item
    			return inventory.indexOf(itemFromInventory);		// Return the index if it already exists
    		}
    	}
    	// This code is only reached if the item is not found
    	return -1;													// Return -1 if the item does not exist in inventory
    }
    
    /**
     * Prompts the user to pick what type of FoodItem to add to inventory.
     * Loop until the user picks a valid item type.
     * Prompts the user to enter a new item code. Loop until the user enters a new, unique, and valid code.
     * Prompts the user to fill in the rest of the item data member fields. Adds the newly created item record to the inventory.
     * @param scanner A scanner object used to read in user input.
     * @param fromFile Indicates whether or not the scanner is reading from a file.
     * @return true if an item was successfully added to the inventory, false otherwise.
     * @throws FileNotFoundException If a user enters a file name that does not exist.
     */
    public boolean addItem(Scanner scanner, boolean fromFile) throws FileNotFoundException {
        boolean validItemType = false;
        
        if (numItems >= MAX_INVENTORY) {																		// Check if inventory is full
        	return false;
        }
        while (validItemType == false) {																		// Loop until the user picks a valid FoodItem type
        	if (fromFile == false) {
        		System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p), or juice(j)? ");	// Prompt user to pick a FoodItem type
        	}
	        try {
	            String itemType = scanner.next();																// Read in user input
	            int existingItemIndex;
	            switch(itemType) {
	                case "f":																					// Fruit
	                	Fruit fruit = new Fruit();																// Instantiate Fruit object
	                	
	                	do {
	                		fruit.inputCode(scanner, fromFile);													// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(fruit);											// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");									// If the code already exists, print error message
	                			if (fromFile) {
	                				return false;
	                			}
	                		}
	                	} while (existingItemIndex != -1);														// Reiterate if user entered a non-unique item code
	                	
	                	fruit.addItem(scanner, fromFile);														// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(fruit);																	// Add the new fruit record to inventory
	                	Collections.sort(inventory);															// Sort the inventory
	                	numItems++;																				// Increment the counter for number of item records in inventory
	                	validItemType = true;																	// Change flag to indicate the user has entered valid data
	                	break;
	                    
	                case "v":																					// Vegetable
	                	Vegetable vegetable = new Vegetable();													// Instantiate vegetable object
	                	
	                	do {
	                		vegetable.inputCode(scanner, fromFile);												// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(vegetable);										// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");									// If the code already exists, print error message
	                			if (fromFile) {
	                				return false;
	                			}
	                		}
	                	} while (existingItemIndex != -1);														// Reiterate if user entered a non-unique item code
	                	
	                	vegetable.addItem(scanner, fromFile);													// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(vegetable);																// Add the new Vegetable record to inventory
	                	Collections.sort(inventory);															// Sort the inventory
	                	numItems++;																				// Increment the counter for number of item records in inventory
	                	validItemType = true;																	// Change flag to indicate the user has entered valid data
	                	break;
	                	
	                case "p":																					// Preserve
	                	Preserve preserve = new Preserve();														// Instantiate preserve object
	                	
	                	do {
	                		preserve.inputCode(scanner, fromFile);												// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(preserve);										// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");									// If the code already exists, print error message
	                			if (fromFile) {
	                				return false;																// If reading from a file, abort upon reading a duplicate item code
	                			}
	                		}
	                	} while (existingItemIndex != -1);														// Reiterate if user entered a non-unique item code
	                	
	                	preserve.addItem(scanner, fromFile);													// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(preserve);																// Add the new Preserve record to inventory
	                	Collections.sort(inventory);															// Sort the inventory
	                	numItems++;																				// Increment the counter for number of item records in inventory
	                	validItemType = true;																	// Change flag to indicate the user has entered valid data
	                	break;
	                	
	                case "j":																					// Juice
	                	Juice juice = new Juice();																// Instantiate juice object
	                	
	                	do {
	                		juice.inputCode(scanner, fromFile);													// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(juice);											// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");									// If the code already exists, print error message
	                		}
	                	} while (existingItemIndex != -1);														// Reiterate if user entered a non-unique item code
	                	
	                	juice.addItem(scanner, fromFile);														// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(juice);																	// Add the new juice record to inventory
	                	Collections.sort(inventory);															// Sort the inventory
	                	numItems++;																				// Increment the counter for number of item records in inventory
	                	validItemType = true;																	// Change flag to indicate the user has entered valid data
	                	break;
	                default:
	                	throw new IllegalArgumentException();													// Throw exception when user enters a string that is not one of the options
	            }
	        } catch (IllegalArgumentException iae) {
	        	System.out.println("Invalid entry");															// Catch IllegalArgumentException and print error message
	        }
        }
        return true;
    }
    
    /**
     * 
     * Prompts the user the enter a valid item code.
     * Prompts the user to enter the quantity they want to buy/sell
     * Add or subtract from the quantity of an item based on: code, quantity and buy/sell flag.
     * 
     * @param scanner A scanner object to be used for user input.
     * @param buyOrSell Indicates whether the method will be used to buy or sell items. True indicates buying; false indicates selling.
     * @return true if a quantity was successfully updated. Return false otherwise.
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
    	// Exit early if there are no items in inventory
		if (numItems == 0) {
			return false;													// Return false to indicate that the method did not update any quantities
		}
		FoodItem foodItem = new FoodItem();
		foodItem.inputCode(scanner, false);
		int codeIndex = alreadyExists(foodItem);							// Check if the code exists and store its index in inventory if it does exist.
		int quantity;

		if (codeIndex != -1) {												// If the code was found:
			
			if (buyOrSell == true) {										// If method is in "buy mode"
				System.out.print("Enter valid quantity to buy: ");			// Diplay prompt to user
				quantity = scanner.nextInt();								// Read in user input
				
			} else {														// If method is in "sell mode"									
				System.out.print("Enter valid quantity to sell: ");			// Display prompt to user
				quantity = scanner.nextInt();								// Read in user input
			}
			// Check if quantity is a positive integer
			if (quantity > 0) {												// If the quantity is valid
				
				if (buyOrSell == true) {									// If method is in "buy mode":
					inventory.get(codeIndex).updateItem(quantity);			// Pass positive quantity to updateItem() to add to the quantity
				} else {													// If method is in "sell mode":
					inventory.get(codeIndex).updateItem(-quantity);			// Pass negative quantity to updateItem() to subtract from the quantity
				}
				return true;												// Return true to indicate the quantity update was successful											
			} else {														// Invalid quantity
				System.out.println("Invalid quantity...");					// Display error message
				return false;												// Return false to indicate the quantity update was unsuccessful
			}    	
			
		} else {															// If the code was not found
			System.out.println("Code not found in inventory...");			// Display error message
			return false;													// Return false to indicate the quantity udpate was unsuccesful
		}
    }
    /**
     * Prompts the user to input an item code. Uses binary search on the inventory to
     * find a matching item code. Displays the item record if found.
     * @param scanner A scanner object used to read user input.
     */
    public void searchForItem(Scanner scanner) {
        int low = 0;
        int high = numItems - 1;
        FoodItem keyItem = new FoodItem();						
        keyItem.inputCode(scanner, false);																						// Get search key from user

        while (low <= high) {                                                                                              
            int mid = low + (high - low) / 2;                                                                         	// Calculate middle index

            if (inventory.get(mid).getItemCode() == keyItem.getItemCode()) {												// Compare key to item at midpoint of inventory.
                System.out.println(inventory.get(mid).toString()); 																			// Display food item record if found
            	return;                                                                                             	// Exit
            }
            else if (inventory.get(mid).getItemCode() < keyItem.getItemCode()) {                                                                              	// If middle element is less than the key, ignore all elements to the left of middle element
                low = mid + 1;                                                                                          // Set the new low index to mid + 1
            }
            else {                                                                                                      // If middle element is greater than the key, ignore all elements to the right of the middle element
                high = mid - 1;                                                                                         // Set the new high index to mid - 1
            }   
        }
        
        // This code only runs if the key is not found
        System.out.println("Code not found in inventory...");                                      	// Display "key not found" message
        return;                                                                                                        	// Return sentinal value
    }
    
    /**
     * Prompts the user to enter a file name to create a new file.
     * Copies the food item records into this new file.
     * 
     * @param scanner The scanner object used to read user input.
     * @throws IOException If an error occurs while writing to a file.
     */
    public void saveToFile(Scanner scanner) throws IOException {
		System.out.print("Enter the filename to save to: ");		// Display prompt to user
		String fileName = scanner.next();							// Get file name from user
		
		// Create a new file given the file name
		File fileObj = new File(fileName);
		fileObj.createNewFile();
		
		// Write to the file	
		FileWriter writer = new FileWriter(fileName);				// Pass file name to fileWriter
		
		for (int i = 0; i < numItems; i++) {						// Traverse numbers array and write each number to the file
			inventory.get(i).outputItem(writer);
		}
		
		writer.close();
	}
    
    /**
     * Prompts the user to enter a file name to read from.
     * Copies the food item records from the file into the inventory.
     * If a duplicate item code is encountered in the file, stop reading.
     * 
     * @param scanner The scanner object used to read user input.
     * @throws FileNotFoundException If the user inputs a file name that does not exist.
     */
    public void readFromFile(Scanner scanner) throws FileNotFoundException {
    	System.out.print("Enter the filename to read from: ");
		String fileName = scanner.next();														// Get file name from user
		
		Scanner fileReader = new Scanner(new File(fileName));									// create a scanner object that will read from the given file name
		
		while (fileReader.hasNext()) {															// Read until the end of the file
			if (addItem(fileReader, true) == false) {											// If an item is unsuccessfully added to the inventory, stop reading the file
				System.out.println("Error Encountered while reading the file, aborting...");	// Display error message
				break;
			}
		}
		
		fileReader.close();		
    }
}
