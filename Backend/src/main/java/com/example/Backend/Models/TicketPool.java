package com.example.Backend.Models;
import java.util.Vector;

public class TicketPool {

    private Customer customer;
    private int maxCapacity;
    private int totalTickets;

    Vector<String> tickets = new Vector<>(maxCapacity);

    public TicketPool(int totalTickets, int maxCapacity) {
        this.totalTickets = totalTickets;
        this.maxCapacity = maxCapacity;

    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }


    public void totalTickets() {

        tickets.clear();

        for (int j = 1; j <= totalTickets; j++) {
            tickets.add("ticket"+j);
        }
        System.out.println(totalTickets + " Tickets in the pool");
    }


    public synchronized void addTicket(String ticket) {
        // Wait until there's space in the pool
        while (tickets.size() >= maxCapacity) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted while waiting to add ticket.");
                Thread.currentThread().interrupt(); // Restore interrupt status
            }
        }

        tickets.add(ticket);
        System.out.println(ticket);

        // Notify other threads that a ticket has been added
        notifyAll();
    }



    public synchronized void removeTicket (String ticket) {

        while (tickets.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("System Interrupted.");
            }
        }

        tickets.removeFirst();
        System.out.println(ticket);
        notifyAll();
    }

}
