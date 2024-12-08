package ticketingsystem;

import java.util.Scanner;

public class Customer {
    private final String username;
    private final String password;
    private final String email;
    private final String phoneNumber;

    public Customer(String username, String password, String email, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void handleCustomerMenu(Scanner scanner, TicketPool ticketPool) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. Purchase Tickets");
            System.out.println("2. View Ticket Pool Status");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Utility.getValidatedChoice(scanner, 3);

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter number of tickets to purchase: ");
                    int count = Utility.getValidatedChoice(scanner, ticketPool.getTicketsAdded());
                    if (ticketPool.removeTickets(count)) {
                        System.out.println("Purchase successful!");
                    } else {
                        System.out.println("[ERROR] Not enough tickets available.");
                    }
                }
                case 2 -> ticketPool.printSystemStatus();
                case 3 -> {
                    loggedIn = false;
                    System.out.println("Logged out successfully.");
                }
                default -> System.out.println("[ERROR] Invalid choice.");
            }
        }
    }
}
