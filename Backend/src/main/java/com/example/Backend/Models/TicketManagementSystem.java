package com.example.Backend.Models;

import com.example.Backend.Inputs;

public class TicketManagementSystem {

public void start(Inputs cli) throws InterruptedException{

    Configuration c1 = new Configuration(cli);
    c1.SaveTransactions();

    TicketPool ticketPool = new TicketPool(cli.getTotalTickets(), cli.getMaxTicketCapacity());
    ticketPool.totalTickets();


    Customer customer1 = new Customer(ticketPool, "Customer ID", cli.getCustomerRetrievalRate());
    Thread customerThread = new Thread(customer1);
    customerThread.start();


    // Wait for the customer thread to finish
    try {
        customerThread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }

    Vendor vendor1 = new Vendor(ticketPool, "Vendor ", cli.getTicketReleaseRate());
    Thread vendorThread1 = new Thread(vendor1);
    vendorThread1.start();

    Customer2 customer2 = new Customer2(ticketPool, "Customer ID", cli.getCustomerRetrievalRate());
    Thread customer2Thread = new Thread(customer2);
    customer2Thread.start();

    try {
        // Wait for vendor and customer threads to finish
        vendorThread1.join();
        customer2Thread.join();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }


}


}
