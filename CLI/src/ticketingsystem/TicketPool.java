package ticketingsystem;

public class TicketPool {
    private int ticketsAdded = 0;
    private final int maxCapacity;

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTickets(int count) {
        if (ticketsAdded + count <= maxCapacity) {
            ticketsAdded += count;
            System.out.println(count + " tickets added successfully. Total tickets: " + ticketsAdded);
        } else {
            System.out.println("[ERROR] Adding tickets exceeds the maximum capacity.");
        }
    }

    public synchronized boolean removeTickets(int count) {
        if (ticketsAdded >= count) {
            ticketsAdded -= count;
            System.out.println(count + " tickets removed successfully. Remaining tickets: " + ticketsAdded);
            return true;
        } else {
            System.out.println("[ERROR] Not enough tickets available.");
            return false;
        }
    }

    public void printSystemStatus() {
        System.out.println("Tickets available: " + ticketsAdded + "/" + maxCapacity);
    }

    public int getTicketsAdded() {
        return ticketsAdded;
    }
}
