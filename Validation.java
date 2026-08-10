import java.util.Scanner;

public class Validation {

    public int getMenuChoice(Scanner sc) {

        boolean valid = false;
        int choice = 0;

        while (!valid) {

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

            boolean valid = false;
            String category = "";

            while (!valid) {

                System.out.println("\nSelect Category:");
                System.out.println("1. Clothing");
                System.out.println("2. Electronics");
                System.out.println("3. Entertainment");

                System.out.print("Enter your choice: ");
                String input = sc.nextLine();

                switch (input) {

                    case "1":
                        category = "Clothing";
                        valid = true;
                        break;

                    case "2":
                        category = "Electronics";
                        valid = true;
                        break;

                    case "3":
                        category = "Entertainment";
                        valid = true;
                        break;

                    default:
                        System.out.println("Invalid input! Please enter a number from 1 to 3 only.");
                }
            }

            return category;
        }

    
        public String getItemID(Scanner sc, Inventory inventory) {

            boolean valid = false;
            String id = "";

            while (!valid) {

                System.out.print("Enter ID: ");
                String input = sc.nextLine();

                if (input.isEmpty()) {
                    System.out.println("ID cannot be empty!");

                } else if (inventory.idExists(input)) {
                    System.out.println("ID already exists! Please enter a different ID.");

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

                    if (input.isEmpty()) {

                        System.out.println("Name cannot be empty!");

                    } else if (!input.matches("[a-zA-Z0-9 #\\-]+")) {

                        System.out.println("Invalid name! Please use letters, numbers, hyphens, or # only.");

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

                } else if (!input.matches("\\d+")) {
                    System.out.println("Invalid quantity! Please enter a whole number.");

                } else {
                    quantity = Integer.parseInt(input);
                    valid = true;

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

                } else if (!input.matches("\\d+(\\.\\d+)?")) {
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

}