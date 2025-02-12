/**
 * CET - CS Academic Level 3
 * Student Name: Ryan Nguyen
 * Student Number: 041137485
 * Section #: 302
 * Course: CST8130 - Data Structures
 * @author/Professor: James Mwangi PhD. 
 * 
  */
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
     * @param item A FoodItem object to be added to the inventory
     * @return the index of the item if it already exists in inventory. Return -1 if the food item does not exist in inventory.
     */
    public int alreadyExists(FoodItem newItem) {    	
    	
    	
    	for (FoodItem itemFromInventory : inventory) {				// Iterate through all items in inventory
    		if (itemFromInventory.isEqual(newItem)) {				// Compare item in inventory to passed in item
    			return inventory.indexOf(itemFromInventory);		// Return the index if it already exists
    		}
    	}
    	return -1;													// Return -1 if the item does not exist in inventory
    }
    
    /**
     * Prompts the user to pick what type of FoodItem to add to inventory.
     * Loop until the user picks a valid item type.
     * Prompts the user to enter a new item code. Loop until the user enters a new, unique, and valid code.
     * Prompts the user to fill in the rest of the item data member fields. Adds the newly created item record to the inventory.
     * @param scanner A scanner object used to read in user input.
     * @return true if an item was successfully added to the inventory, false otherwise.
     */
    public boolean addItem(Scanner scanner) {
        boolean validItemType = false;
        
        if (numItems >= MAX_INVENTORY) {
        	return false;
        }
        while (validItemType == false) {																	// Loop until the user picks a valid FoodItem type
            System.out.print("Do you wish to add a fruit(f), vegetable(v), preserve(p), or juice(j)? ");	// Prompt user to pick a FoodItem type
            
	        try {
	            String itemType = scanner.next();															// Read in user input
	            int existingItemIndex;
	            switch(itemType) {
	                case "f":																				// Fruit
	                	Fruit fruit = new Fruit();															// Instantiate Fruit object
	                	
	                	do {
	                		fruit.inputCode(scanner);														// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(fruit);										// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");								// If the code already exists, print error message
	                		}
	                	} while (existingItemIndex != -1);													// Reiterate if user entered a non-unique item code
	                	
	                	fruit.addItem(scanner);																// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(fruit);																// Add the new fruit record to inventory
	                	Collections.sort(inventory);														// Sort the inventory
	                	numItems++;																			// Increment the counter for number of item records in inventory
	                	validItemType = true;																// Change flag to indicate the user has entered valid data
	                	break;
	                    
	                case "v":																				// Vegetable
	                	Vegetable vegetable = new Vegetable();												// Instantiate vegetable object
	                	
	                	do {
	                		vegetable.inputCode(scanner);													// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(vegetable);									// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");								// If the code already exists, print error message
	                		}
	                	} while (existingItemIndex != -1);													// Reiterate if user entered a non-unique item code
	                	
	                	vegetable.addItem(scanner);															// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(vegetable);															// Add the new Vegetable record to inventory
	                	Collections.sort(inventory);														// Sort the inventory
	                	numItems++;																			// Increment the counter for number of item records in inventory
	                	validItemType = true;																// Change flag to indicate the user has entered valid data
	                	break;
	                	
	                case "p":																				// Preserve
	                	Preserve preserve = new Preserve();													// Instantiate preserve object
	                	
	                	do {
	                		preserve.inputCode(scanner);													// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(preserve);									// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");								// If the code already exists, print error message
	                		}
	                	} while (existingItemIndex != -1);													// Reiterate if user entered a non-unique item code
	                	
	                	preserve.addItem(scanner);															// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(preserve);															// Add the new Preserve record to inventory
	                	Collections.sort(inventory);														// Sort the inventory
	                	numItems++;																			// Increment the counter for number of item records in inventory
	                	validItemType = true;																// Change flag to indicate the user has entered valid data
	                	break;
	                	
	                case "j":																				// Juice
	                	Juice juice = new Juice();															// Instantiate juice object
	                	
	                	do {
	                		juice.inputCode(scanner);														// Prompt user to enter a valid code
	                		existingItemIndex = alreadyExists(juice);										// Check if the code already exists in inventory
	                		
	                		if (existingItemIndex != -1) {
	                			System.out.println("Item code already exists");								// If the code already exists, print error message
	                		}
	                	} while (existingItemIndex != -1);													// Reiterate if user entered a non-unique item code
	                	
	                	juice.addItem(scanner);																// Prompt the user to fill in the rest of the data member fields.
	                	inventory.add(juice);																// Add the new juice record to inventory
	                	Collections.sort(inventory);														// Sort the inventory
	                	numItems++;																			// Increment the counter for number of item records in inventory
	                	validItemType = true;																// Change flag to indicate the user has entered valid data
	                	break;
	                default:
	                	throw new IllegalArgumentException();												// Throw exception when user enters a string that is not one of the options
	            }
	        } catch (IllegalArgumentException iae) {
	        	System.out.println("Invalid entry");														// Catch IllegalArgumentException and print error message
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
		foodItem.inputCode(scanner);
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
}
