package ticketingsystem;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    public Vendor(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 / releaseRate); // Simulate release rate
                ticketPool.addTickets(1); // Add a ticket to the pool
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
