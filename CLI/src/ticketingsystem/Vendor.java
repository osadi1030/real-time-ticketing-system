package ticketingsystem;

import java.util.Scanner;

public class Vendor {
    public static void handleVendorMenu(Scanner scanner, TicketPool ticketPool) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\nVendor Menu:");
            System.out.println("1. Add Tickets");
            System.out.println("2. View Ticket Pool Status");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Utility.getValidatedChoice(scanner, 3);

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter number of tickets to add: ");
                    int count = scanner.nextInt();
                    ticketPool.addTickets(count);
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
