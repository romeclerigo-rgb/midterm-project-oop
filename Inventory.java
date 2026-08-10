import java.util.*;

public class Inventory {

    private ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();
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

}