package ticketingsystem;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class TicketPool {
    private final List<Integer> tickets;

    public TicketPool(int initialSize) {
        tickets = Collections.synchronizedList(new LinkedList<>());
        for (int i = 0; i < initialSize; i++) {
            tickets.add(i);
        }
    }

    // Method to add tickets to the pool (Producer)
    public synchronized void addTickets(int numberOfTickets) {
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(tickets.size() + 1); // Add a ticket
            System.out.println("Ticket added. Current pool size: " + tickets.size());
        }
    }

    // Method to remove a ticket from the pool (Consumer)
    public synchronized boolean removeTicket() {
        if (!tickets.isEmpty()) {
            tickets.remove(0); // Remove a ticket
            System.out.println("Ticket purchased. Remaining tickets: " + tickets.size());
            return true;
        }
        return false;
    }

    public int getSize() {
        return tickets.size();
    }
}
