import java.util.*;
public class Main {

    public static void printHeader(String title) {
        System.out.println();
        System.out.println("======================================");
        System.out.printf(" %-37s %n", title);
        System.out.println("======================================");
    }

public static void printMessage(String message) {
        System.out.println("======================================");
        System.out.printf(" %-37s %n", message);
        System.out.println("======================================");
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
                        }

                        inventory.addItem(item);
                        printMessage("Item added successfully!");
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
                                        int newQuantity = validation.getQuantity(sc);
                                        inventory.updateQuantity(updateItem, newQuantity);

                                        printHeader("Quantity updated from "
                                                + oldQuantity + " to " + newQuantity + ".");
                                        break;

                                    case 2:
                                        double oldPrice = updateItem.getPrice();
                                        double newPrice = validation.getPrice(sc);

                                        inventory.updatePrice(updateItem, newPrice);
                                        System.out.println("======================================");
                                        System.out.printf("Price updated from Php%,.2f to Php%,.2f.%n",
                                                oldPrice, newPrice);
                                        System.out.println("======================================");
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
                                printMessage("Item removed successfully!");
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
                            inventory.displayByCategory(displayCategory);
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
                                System.out.println("=============================================================================================");
                            }
                        }
                        break;

                    case 7:
                        if (inventory.isEmpty()) {
                            printMessage("No items yet.");
                        } else {
                            printHeader("SORT ITEMS");

                            int sortChoice = validation.getSortChoice(sc);

                            switch (sortChoice) {
                                case 1:
                                    inventory.sortByQuantity();
                                    printMessage("Items sorted by quantity.");
                                    break;

                                case 2:
                                    inventory.sortByPrice();
                                    printMessage("Items sorted by price.");
                                    break;
                            }
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
                }
                System.out.println();
            }
    sc.close();
    }
}
