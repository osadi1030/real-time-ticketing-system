package ticketingsystem;

public class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int retrievalRate;

    public Customer(TicketPool ticketPool, int retrievalRate) {
        this.ticketPool = ticketPool;
        this.retrievalRate = retrievalRate;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000 / retrievalRate); // Simulate retrieval rate
                if (!ticketPool.removeTicket()) {
                    System.out.println("No tickets available for purchase.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
