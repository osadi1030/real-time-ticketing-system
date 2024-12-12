package com.example.Backend.Models;

import java.io.FileWriter;
import java.io.IOException;


public class Customer2 implements Runnable{

    private TicketPool ticketPool;
    private String customerName;
    private int customerRetrieval;


    public Customer2(TicketPool ticketPool, String customerName, int customerRetrieval) {
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
        for (int i = 1; i <= ticketPool.getMaxCapacity(); i++) {
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
        System.out.println("Ticket pool reached maximum ticket capacity.");
        Configuration.log("Ticket pool reached maximum ticket capacity.");
        System.out.println("Thank you for buying tickets...");
        Configuration.log("");
        System.out.println();
    }
}
