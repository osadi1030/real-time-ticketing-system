package ticketingsystem;

import java.util.Scanner;

public class TicketingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Configuration config;

        // Prompt for system configuration
        System.out.println("Enter total tickets:");
        int totalTickets = scanner.nextInt();
        System.out.println("Enter ticket release rate:");
        int ticketReleaseRate = scanner.nextInt();
        System.out.println("Enter customer retrieval rate:");
        int customerRetrievalRate = scanner.nextInt();
        System.out.println("Enter maximum ticket capacity:");
        int maxTicketCapacity = scanner.nextInt();

        // Create a configuration object
        config = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

        // Save configuration to file
        try {
            Configuration.saveConfiguration(config, "config.json");
        } catch (Exception e) {
            System.out.println("Error saving configuration: " + e.getMessage());
        }

        // Initialize ticket pool with total tickets
        TicketPool ticketPool = new TicketPool(totalTickets);

        // Start vendor threads (producers)
        Thread vendorThread = new Thread(new Vendor(ticketPool, ticketReleaseRate));
        vendorThread.start();

        // Start customer threads (consumers)
        Thread customerThread = new Thread(new Customer(ticketPool, customerRetrievalRate));
        customerThread.start();
    }
}
