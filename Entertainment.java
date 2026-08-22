public class Entertainment extends Item {

    public Entertainment(String id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price, category);
    }

    @Override
public void displayInfo() {

    System.out.printf(
        "%-25s | %-15s | %-25s | %12d pcs | Php %,13.2f%n",
        getId(),
        getCategory(),
        getName(),
        getQuantity(),
        getPrice()
    );

    }
}