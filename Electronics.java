public class Electronics extends Item {

    public Electronics(String id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price, category);
    }

    @Override
    public void displayInfo() {

        System.out.println(
            getId() + " | " +
            getName() + " | " +
            getQuantity() + " | " +
            getPrice() + " | Electronics"
        );
    }
}