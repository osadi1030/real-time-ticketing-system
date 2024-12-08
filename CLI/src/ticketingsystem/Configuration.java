package ticketingsystem;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    // Default constructor
    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    // Method to save configuration to a JSON file
    public void saveConfigurationToFile(String filename) throws JsonIOException, IOException {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(filename)) {
            gson.toJson(this, writer);
        }
    }

    // Method to load configuration from a JSON file
    public static Configuration loadConfigurationFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        try (FileReader reader = new FileReader(filename)) {
            return gson.fromJson(reader, Configuration.class);
        }
    }
}
