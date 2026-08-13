import java.util.*;
public class Main {
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);   
        Validation validation = new Validation();

        Inventory inventory = new Inventory();

        boolean loop = true;

            while (loop){

                System.out.println("=======================================");
                System.out.println("      Inventory Management System      ");
                System.out.println("=======================================");
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

                            System.out.println("Item added successfully!");
                            break;

                    case 2:
                        System.out.print("Enter ID: ");
                        String updateID = sc.nextLine();

                        Item updateItem = inventory.findItem(updateID);

                        if (updateItem == null) {

                            System.out.println("Item not found!");

                        } else {

                            int updateChoice = validation.getUpdateChoice(sc);

                            switch (updateChoice) {

                                case 1:

                                    int oldQuantity = updateItem.getQuantity();

                                    int newQuantity = validation.getQuantity(sc);

                                    inventory.updateQuantity(updateItem, newQuantity);
                                    System.out.println("Quantity updated from " + oldQuantity + " to " + newQuantity + ".");

                                    break;

                                case 2:

                                    double oldPrice = updateItem.getPrice();

                                    double newPrice = validation.getPrice(sc);

                                    inventory.updatePrice(updateItem, newPrice);

                                    System.out.println("Price updated from "
                                            + oldPrice + " to " + newPrice + ".");

                                    break;
                            }
                        }

                        break;

                    case 3:
                        System.out.print("Enter ID: ");
                        String removeID = sc.nextLine();

                        boolean removed = inventory.removeItem(removeID);

                        if (removed) {
                            System.out.println("Item removed successfully!");

                        } else {
                            System.out.println("Item not found!");
                        }
                        break;

                    case 4:
                        String displayCategory = validation.getCategory(sc);
                        inventory.displayByCategory(displayCategory);
                        break;

                    case 5:
                        inventory.displayAllItems();
                        break;

                    case 6:
                        System.out.print("Enter ID: ");
                        String searchID = sc.nextLine();

                        Item searchItem = inventory.findItem(searchID);

                        if (searchItem == null) {

                            System.out.println("Item not found!");

                        } else {

                            searchItem.displayInfo();
                        }

                        break;

                    case 7:
                        int sortChoice = validation.getSortChoice(sc);
                        switch (sortChoice) {

                            case 1:
                                inventory.sortByName();
                                System.out.println("Items sorted by name.");
                                break;

                            case 2:
                                inventory.sortByPrice();
                                System.out.println("Items sorted by price.");
                                break;
                        }

                        break;

                    case 8:
                        inventory.displayLowStockItems();
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
