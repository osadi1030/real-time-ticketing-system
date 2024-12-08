package ticketingsystem;

import java.io.IOException;
import java.util.Scanner;

import java.util.Map;
import java.util.HashMap;

public class TicketingSystem {
    private static final Map<String, String> users = new HashMap<>();
    private static final Map<String, Customer> customers = new HashMap<>();
    private static final String CONFIG_FILE = "config.json";
    private static Configuration configuration;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        // Load configuration from the file at the start
        try {
            configuration = Configuration.loadConfigurationFromFile(CONFIG_FILE);
            System.out.println("Configuration loaded successfully.");
        } catch (IOException e) {
            System.out.println("No configuration found. Using default settings.");
            configuration = new Configuration(100, 5, 3, 200); // Default settings
        }

        TicketPool ticketPool = new TicketPool(configuration.getMaxTicketCapacity());
        displayWelcomeMessage();

        while (running) {
            displayMainMenu();
            int choice = Utility.getValidatedChoice(scanner, 8); // Adjust menu choice

            switch (choice) {
                case 1 -> UserManager.registerUser(scanner, "Vendor", users, customers);
                case 2 -> UserManager.registerUser(scanner, "Customer", users, customers);
                case 3 -> UserManager.loginUser("Vendor", scanner, ticketPool, users, customers);
                case 4 -> UserManager.loginUser("Customer", scanner, ticketPool, users, customers);
                case 5 -> ticketPool.printSystemStatus();
                case 6 -> printActivityLogs();
                case 7 -> configureSystem(scanner); // New option to configure system
                case 8 -> {
                    running = false;
                    System.out.println("Thank you for using the Real-Time Ticketing System. Goodbye!");
                }
                default -> System.out.println("[ERROR] Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("=========================================");
        System.out.println("  Welcome to the Real-Time Ticketing System  ");
        System.out.println("=========================================");
    }

    private static void displayMainMenu() {
        System.out.println("\nMain Menu:");
        System.out.println("1. Vendor Register");
        System.out.println("2. Customer Register");
        System.out.println("3. Vendor Login");
        System.out.println("4. Customer Login");
        System.out.println("5. View System Status");
        System.out.println("6. View Activity Logs");
        System.out.println("7. Configure System Settings");
        System.out.println("8. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void configureSystem(Scanner scanner) {
        System.out.println("\n-- System Configuration --");
        System.out.print("Enter total tickets available: ");
        int totalTickets = scanner.nextInt();
        System.out.print("Enter ticket release rate: ");
        int ticketReleaseRate = scanner.nextInt();
        System.out.print("Enter customer retrieval rate: ");
        int customerRetrievalRate = scanner.nextInt();
        System.out.print("Enter maximum ticket capacity: ");
        int maxTicketCapacity = scanner.nextInt();

        // Update the configuration object with new values
        configuration = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        // Save configuration to file
        try {
            configuration.saveConfigurationToFile(CONFIG_FILE);
            System.out.println("Configuration saved successfully.");
        } catch (IOException e) {
            System.out.println("[ERROR] Failed to save configuration.");
        }
    }

    private static void printActivityLogs() {
        System.out.println("-- Activity Logs --");
        users.forEach((username, action) -> {
            System.out.println("Vendor '" + username + "' performed an action. ");
        });
        customers.forEach((username, customer) -> {
            System.out.println("Customer '" + username + "' performed an action.");
        });
    }
}
