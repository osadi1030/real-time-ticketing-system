package com.example.Backend;

public class Inputs {

    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;


    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }


    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }


    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate(){
        return (1000 * (100 - ticketReleaseRate)) / 100;
    }

    public int getCustomerRetrievalRate(){
        return (1000 * (100 - customerRetrievalRate)) / 100;
    }

    public int getMaxTicketCapacity(){
        return maxTicketCapacity;
    }


}
