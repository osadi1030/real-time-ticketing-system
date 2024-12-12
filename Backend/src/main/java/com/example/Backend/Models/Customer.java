package com.example.Backend.Models;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

public class Customer implements Runnable{

    private TicketPool ticketPool;
    private String customerName;
    private int customerRetrieval;


    public Customer(TicketPool ticketPool, String customerName, int customerRetrieval) {
        this.ticketPool = ticketPool;
        this.customerName = customerName;
        this.customerRetrieval = customerRetrieval;
    }


    public String getCustomerName() {
        return customerName;
    }

    @Override
    public void run() {
        // Loop until there are no tickets left in the pool
        for (int i = 1; i <= ticketPool.getTotalTickets(); i++) {
            String ticket = customerName+i+" purchased a ticket";
            Configuration.log(customerName+i+" purchased a ticket");
            ticketPool.removeTicket(ticket); // Call without passing the ticket string


            try{
                Thread.sleep(customerRetrieval);
            }catch(InterruptedException e){
                System.out.println("programme interrupted");
            }
        }
        System.out.println();
        System.out.println("Ticket pool is empty.");
        Configuration.log("Ticket pool is empty.");
        System.out.println("Adding tickets to the ticketpool");
        Configuration.log("Adding tickets to the ticketpool");
        System.out.println();

    }



}
