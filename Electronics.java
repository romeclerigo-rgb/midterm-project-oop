public class Electronics extends Item {

    public Electronics(String id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price, category);
    }

    @Override
    public void displayInfo() {
        System.out.printf(
            "%-10s | %-15s | %-25s | %11s | %13s%n",
            getId(),
            getCategory(),
            getName(),
            String.format("%,d pcs", getQuantity()),
            "Php " + String.format("%,.2f", getPrice())
        );
    }
}