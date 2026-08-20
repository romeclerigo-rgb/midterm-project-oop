public class Electronics extends Item {

    public Electronics(String id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price, category);
    }

    @Override
    public void displayInfo() {
        System.out.printf(
        "%-25s | %-15s | %-25s | %12dpcs | Php%12.2f%n",
        getId(),
        getCategory(),
        getName(),
        getQuantity(),
        getPrice()
    );
    }
}