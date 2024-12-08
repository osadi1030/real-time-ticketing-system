package ticketingsystem;

import java.util.Map;
import java.util.Scanner;

public class UserManager {

    public static void registerUser(Scanner scanner, String role, Map<String, String> users, Map<String, Customer> customers) {
        System.out.println("-- " + role + " Registration --");

        String username = Utility.getValidatedInput(scanner, "Enter your username (min 5 characters, alphanumeric): ",
                "^[a-zA-Z0-9]{5,}$", "Username must be at least 5 characters long and contain only letters or numbers.");

        String password = Utility.getValidatedInput(scanner, "Enter your password (min 8 characters with letters, numbers, special chars): ",
                "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", "Password must include letters, numbers, and special characters.");

        if ("Vendor".equalsIgnoreCase(role)) {
            users.put(username, password);
        } else {
            String email = Utility.getValidatedInput(scanner, "Enter your email: ",
                    "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", "Please enter a valid email address.");

            String phoneNumber = Utility.getValidatedInput(scanner, "Enter your phone number (min 10 digits): ",
                    "^\\d{10,}$", "Phone number must be at least 10 digits long.");

            customers.put(username, new Customer(username, password, email, phoneNumber));
        }
        System.out.println(role + " '" + username + "' registered successfully.");
    }

    public static void loginUser(String role, Scanner scanner, TicketPool ticketPool, Map<String, String> users, Map<String, Customer> customers) {
        System.out.println("-- " + role + " Login --");
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        if ("Vendor".equalsIgnoreCase(role)) {
            if (!users.containsKey(username)) {
                System.out.println("[ERROR] Username not found.");
                return;
            }
        } else {
            if (!customers.containsKey(username)) {
                System.out.println("[ERROR] Username not found.");
                return;
            }
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if ("Vendor".equalsIgnoreCase(role)) {
            if (!users.get(username).equals(password)) {
                System.out.println("[ERROR] Incorrect password. Please try again.");
                return;
            }
            System.out.println("Login successful! Welcome, " + username + ".");
            Vendor.handleVendorMenu(scanner, ticketPool);
        } else {
            Customer customer = customers.get(username);
            if (!customer.getPassword().equals(password)) {
                System.out.println("[ERROR] Incorrect password. Please try again.");
                return;
            }
            System.out.println("Login successful! Welcome, " + username + ".");
            customer.handleCustomerMenu(scanner, ticketPool);
        }
    }
}
