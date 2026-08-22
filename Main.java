import java.util.*;
public class Main {

    public static void printHeader(String title) {
        System.out.println();
        System.out.println("======================================");
        System.out.printf(" %-37s %n", title);
        System.out.println("======================================");
    }

public static void printMessage(String message) {
    int width = Math.max(38, message.length() + 2);

    System.out.println("=".repeat(width));
    System.out.printf("%-" + width + "s%n", " " + message);
    System.out.println("=".repeat(width));
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);   
        Validation validation = new Validation();

        Inventory inventory = new Inventory();

        boolean loop = true;

            while (loop){

                System.out.println("======================================");
                System.out.println("     Inventory Management System      ");
                System.out.println("======================================");
                System.out.println("1. Add Item");
                System.out.println("2. Update Item");
                System.out.println("3. Remove Item");
                System.out.println("4. Display Items by Category");
                System.out.println("5. Display All Items ");
                System.out.println("6. Search Item");
                System.out.println("7. Sort Items");
                System.out.println("8. Display Low Stock Items ");
                System.out.println("9. Exit");
                
                int choice = validation.getMenuChoice(sc);
                
                switch(choice){
                    case 1:
                        printHeader("ADD ITEM");

                        String category = validation.getCategory(sc);

                        if (category.isEmpty()) {
                            break;
                        }

                        String id = validation.getItemID(sc, inventory);
                        String name = validation.getItemName(sc);
                        int quantity = validation.getQuantity(sc);
                        double price = validation.getPrice(sc);

                        Item item = null;

                        switch (category) {
                            case "Clothing":
                                item = new Clothing(id, name, quantity, price, category);
                                break;

                            case "Electronics":
                                item = new Electronics(id, name, quantity, price, category);
                                break;

                            case "Entertainment":
                                item = new Entertainment(id, name, quantity, price, category);
                                break;

                            default:
                                printMessage("Category does not exist!");
                                break;
                        }

                        if (item != null) {
                            inventory.addItem(item);
                            printMessage("Item added successfully!");
                        }
                        break;

                    case 2:
                        if (inventory.isEmpty()) {

                            printMessage("No items yet.");

                        } else {

                            printHeader("UPDATE ITEM");

                            System.out.print("Enter ID: ");
                            String updateID = sc.nextLine();

                            Item updateItem = inventory.findItem(updateID);

                            if (updateItem == null) {

                                printMessage("Item not found!");

                            } else {

                                int updateChoice = validation.getUpdateChoice(sc);

                                switch (updateChoice) {

                                    case 1:
                                        int oldQuantity = updateItem.getQuantity();
                                        int newQuantity = validation.getUpdateQuantity(sc);
                                        inventory.updateQuantity(updateItem, newQuantity);

                                        printMessage("Quantity of " + updateItem.getName()
                                                + " updated from " + oldQuantity
                                                + " to " + newQuantity + ".");
                                        break;

                                    case 2:
                                        double oldPrice = updateItem.getPrice();
                                        double newPrice = validation.getPrice(sc);

                                        inventory.updatePrice(updateItem, newPrice);

                                        printMessage("Price of " + updateItem.getName()
                                                + " updated from Php" + String.format("%,.2f", oldPrice)
                                                + " to Php" + String.format("%,.2f", newPrice) + ".");

                                        break;
                                }
                            }
                        }

                        break;

                    case 3:

                        if (inventory.isEmpty()) {
                            printMessage("No items yet.");
                        } else {
                            printHeader("REMOVE ITEM");

                            System.out.print("Enter ID: ");
                            String removeID = sc.nextLine();

                            boolean removed = inventory.removeItem(removeID);
                            if (removed) {
                                printMessage("Item has been removed from the inventory!");
                            } else {
                                printMessage("Item not found!");
                            }
                        }
                        break;

                    case 4:
                        if (inventory.isEmpty()) {

                            printMessage("No items yet.");

                        } else {

                            printHeader("DISPLAY BY CATEGORY");

                            String displayCategory = validation.getCategory(sc);

                            if (!displayCategory.isEmpty()) {
                                inventory.displayByCategory(displayCategory);
                            }
                        }

                        break;

                    case 5:
                        if (inventory.isEmpty()) {
                            printMessage("No items yet.");
                        } else {
                            printHeader("ALL ITEMS");
                            inventory.displayAllItems();
                        }
                        break;

                    case 6:
                        if (inventory.isEmpty()) {

                            printMessage("No items yet.");

                        } else {
                            printHeader("SEARCH ITEM");
                            System.out.print("Enter ID: ");
                            String searchID = sc.nextLine();

                            Item searchItem = inventory.findItem(searchID);

                            if (searchItem == null) {
                                printMessage("Item not found!");
                            } else {
                                inventory.displayTableHeader();
                                searchItem.displayInfo();
                                System.out.println("==============================================================================================================");
                            }
                        }
                        break;

                    case 7:
                        if (inventory.isEmpty()) {
                            printMessage("No items yet.");

                        } else {
                            printHeader("SORT ITEMS");
                            int orderChoice = validation.getOrderChoice(sc);
                            boolean ascending = (orderChoice == 1);

                            switch (orderChoice) {
                                case 1:
                                    inventory.sortByQuantity(ascending);
                                    break;

                                case 2:
                                    inventory.sortByPrice(ascending);
                                    break;
                            }
                            if (ascending) {
                                printMessage("Items sorted in Ascending order successfully!");
                            } else {
                                printMessage("Items sorted in Descending order successfully!");
                            }
                            inventory.displayAllItems();
                        }

                        break;
                        
                    case 8:
                        if (inventory.isEmpty()) {
                            printMessage("No items yet.");
                        } else {
                            printHeader("LOW STOCK ITEMS");
                            inventory.displayLowStockItems();
                        }
                        break;
                        
                    case 9:
                        System.out.println("Program exited!");
                        loop = false;
                        break;

                    default:
                        printMessage("Invalid Choice!");
                            break;

                }
                System.out.println();

            }
    sc.close();
    }
}
