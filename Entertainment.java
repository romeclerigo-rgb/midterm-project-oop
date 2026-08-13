public class Entertainment extends Item {

    public Entertainment(String id, String name, int quantity, double price, String category) {
        super(id, name, quantity, price, category);
    }

    @Override
    public void displayInfo() {

        System.out.println(
            getId() + " | " +
            getName() + " | " +
            getQuantity() + " | " +
            getPrice() + " | Entertainment"
        );
    }
}