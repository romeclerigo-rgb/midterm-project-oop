import java.util.*;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
    }
     
    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void addItem(Item item){
        items.add(item);
    }

    public boolean idExists(String id){
        boolean found = false;
        for (Item item : items){
            if (item.getId().equalsIgnoreCase(id)) {
                found = true;
                break;
            }
        }
        return found;

    }

    public Item findItem(String id) {
        Item foundItem = null;

        for (Item item : items) {
            if (item.getId().equalsIgnoreCase(id)) {
                foundItem = item;
                break;
            }
        }
        return foundItem;
    }

    public void updateQuantity(Item item, int quantity) {
        item.setQuantity(quantity);
    }

    public void updatePrice(Item item, double price) {
        item.setPrice(price);
    }

    public boolean removeItem(String id) {
        boolean removed = false;

        for (int i = 0; i < items.size(); i++) {

            if (items.get(i).getId().equalsIgnoreCase(id)) {

                items.remove(i);
                removed = true;
                break;
            }
        }
        return removed;
    }
    //polymorphism
    public void displayByCategory(String category) {
        boolean found = false;

        for (Item item : items) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                if (!found) {
                    displayTableHeader();
                }
                item.displayInfo();
                found = true;
            }
        }
        if (found) {
            System.out.println("=============================================================================================");
        } else {
            System.out.println("No items found in this category."); 
        }
    }
    
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in inventory.");
        } else {
            displayTableHeader();
            for (Item item : items) {
                item.displayInfo();
            }
            System.out.println("=============================================================================================");
        }
    }

    public void displayTableHeader() {
        System.out.println("=============================================================================================");
        System.out.printf(
            "%-10s | %-15s | %-25s | %11s | %13s%n",
            "ID",
            "Category",
            "Name",
            "Quantity",
            "Price"
        );
        System.out.println("=============================================================================================");
    }
    
    public void sortByQuantity() {
        
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - 1 - i; j++) {
                if (items.get(j).getQuantity() > items.get(j + 1).getQuantity()) {
                    Item temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }
    
    
    public void sortByPrice() {
        for (int i = 0; i < items.size() - 1; i++) {
            for (int j = 0; j < items.size() - 1 - i; j++) {
                if (items.get(j).getPrice() > items.get(j + 1).getPrice()) {

                    Item temp = items.get(j);
                    items.set(j, items.get(j + 1));
                    items.set(j + 1, temp);
                }
            }
        }
    }

    public void displayLowStockItems() {
        boolean found = false;
        for (Item item : items) {
            if (item.getQuantity() <= 5) {
                item.displayInfo();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No low stock items.");
        }
    }

}