package com.example.Backend.Models;

public class Vendor implements Runnable{

    private TicketPool ticketPool;
    private String vendorName;
    private int vendorReleaseRate;





    public Vendor(TicketPool ticketPool,String vendorName, int vendorReleaseRate){
        super();
        this.ticketPool = ticketPool;
        this.vendorName = vendorName;
        this.vendorReleaseRate = vendorReleaseRate;


    }


    @Override
    public void run() {
        for (int i = 1; i <= ticketPool.getMaxCapacity(); i++) {

            String ticket = "Vendor Added-Ticket-" + i;
            Configuration.log("Vendor Added-Ticket-" + i);
            //calling ticketpool method
            ticketPool.addTicket(ticket);

            try{
                Thread.sleep(this.vendorReleaseRate);
            }catch(InterruptedException e){
                System.out.println("programme interrupted.");
            }

        }
    }



}
