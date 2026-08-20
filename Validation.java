import java.util.Scanner;

public class Validation {

    public int getMenuChoice(Scanner sc) {

        boolean valid = false;
        int choice = 0;

        while (!valid) {
            System.out.println("======================================");
            System.out.print("Enter your choice: ");
            String input = sc.nextLine();

            if (input.matches("[1-9]")) {

                choice = Integer.parseInt(input);
                valid = true;

            } else {

                System.out.println("Invalid input! Please enter a number from 1 to 9 only.");

            }
        }

        return choice;
    }
        
        public String getCategory(Scanner sc) {

            System.out.print("Enter category: ");
            String input = sc.nextLine();

            String fixed = input.toLowerCase();

            if (fixed.equals("clothing")) {

                return "Clothing";

            } else if (fixed.equals("electronics")) {

                return "Electronics";

            } else if (fixed.equals("entertainment")) {

                return "Entertainment";

            } else {

                System.out.println("Category " + input + " does not exist!");
                return "";
            }
        }

    
        public String getItemID(Scanner sc, Inventory inventory) {

            boolean valid = false;
            String id = "";

            while (!valid) {

                System.out.print("Enter ID: ");
                String input = sc.nextLine();

                if (input.isEmpty()) {
                    System.out.println("ID cannot be empty!");

                } else if (input.length() > 25) {
                    System.out.println("Invalid ID! Maximum length is 25 characters.");

                } else if (!input.matches("[A-Za-z0-9-]+")) {
                    System.out.println(
                        "Invalid ID! Please use letters, numbers, and hyphens only.");

                } else if (!input.matches(".*[A-Za-z0-9].*")) {
                    System.out.println(
                        "Invalid ID! ID must contain at least one letter or number.");

                } else if (inventory.idExists(input)) {
                    System.out.println(
                        "ID already exists! Please enter a different ID.");

                } else {
                    id = input;
                    valid = true;
                }
            }
            return id;
        }

        public String getItemName(Scanner sc) {

            boolean valid = false;
            String name = "";

                while (!valid) {
                    System.out.print("Enter name: ");
                    String input = sc.nextLine();
                    String Iinput = input.trim();

                     if (Iinput.isEmpty()) {
                        System.out.println("Name cannot be empty!");
                    } else if (input.length() > 25) {
                        System.out.println("Invalid name! Maximum length is 25 characters.");
                    } else {
                        name = input;
                        valid = true;
                    }
                }

                return name;
            }

        public int getQuantity(Scanner sc) {
            boolean valid = false;
            int quantity = 0;

            while (!valid) {

                System.out.print("Enter quantity: ");
                String input = sc.nextLine();

                if (input.isEmpty()) {
                    System.out.println("Quantity cannot be empty!");
                } else if (!input.matches("[1-9]\\d*")) {
                    System.out.println("Invalid quantity! Please enter a whole number greater than 0.");
                } else if (input.length() > 5) {
                    System.out.println("Invalid quantity! Maximum quantity is 10,000.");
                } else {
                    quantity = Integer.parseInt(input);
                    if (quantity > 10000) {
                        System.out.println("Invalid quantity! Maximum quantity is 10,000.");
                    } else {
                        valid = true;
                    }
                }
            }
            return quantity;
        }


       public double getPrice(Scanner sc) {
        boolean valid = false;
        double price = 0;

        while (!valid) {

            System.out.print("Enter price: ");
            String input = sc.nextLine();

            if (input.isEmpty()) {

                System.out.println("Price cannot be empty!");

            } else if (!input.matches("[1-9]\\d*(\\.\\d+)?")) {

                System.out.println("Invalid price! Please enter a valid number.");

            } else {

                price = Double.parseDouble(input);
                valid = true;
            }
        }

        return price;
        }

        public int getUpdateChoice(Scanner sc) {

            boolean valid = false;
            int choice = 0;

            while (!valid) {

                System.out.println("\nWhat do you want to update?");
                System.out.println("1. Quantity");
                System.out.println("2. Price");

                System.out.print("Enter your choice: ");
                String input = sc.nextLine();

                if (input.matches("[1-2]")) {

                    choice = Integer.parseInt(input);
                    valid = true;

                } else {

                    System.out.println("Invalid input! Please enter 1 or 2 only.");

                }
            }

            return choice;
        }

        public int getUpdateQuantity(Scanner sc) {
            boolean valid = false;
            int quantity = 0;

            while (!valid) {

                System.out.print("Enter quantity: ");
                String input = sc.nextLine();

                if (input.isEmpty()) {

                    System.out.println("Quantity cannot be empty!");

                } else if (!input.matches("\\d+")) {

                    System.out.println(
                        "Invalid quantity! Please enter a whole number."
                    );

                } else if (input.length() > 5) {

                    System.out.println(
                        "Invalid quantity! Maximum quantity is 10,000."
                    );

                } else {

                    quantity = Integer.parseInt(input);

                    if (quantity > 10000) {

                        System.out.println(
                            "Invalid quantity! Maximum quantity is 10,000."
                        );

                    } else {

                        valid = true;
                    }
                }
            }

            return quantity;
        }
        public int getOrderChoice(Scanner sc) {
        boolean valid = false;
        int choice = 0;

        while (!valid) {
            System.out.println("\n1. Ascending");
            System.out.println("2. Descending");
            System.out.print("Enter your choice: ");
            String input = sc.nextLine();

            if (input.matches("[1-2]")) {
                choice = Integer.parseInt(input);
                valid = true;
            } else {
                System.out.println("Invalid input! Please enter 1 or 2 only.");
            }
        }
        return choice;
    }

}