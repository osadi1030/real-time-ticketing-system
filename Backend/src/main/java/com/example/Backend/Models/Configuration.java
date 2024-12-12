package com.example.Backend.Models;

import com.example.Backend.Inputs;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Configuration {

    private Inputs cli;

    public Configuration(Inputs cli){
        this.cli = cli;
    }

    public void SaveTransactions(){
        try(FileWriter file = new FileWriter("System_Details.txt",true)){
            file.write("");
            file.write(String.valueOf("Total tickets : "+cli.getTotalTickets()+"\n"));
            file.write(String.valueOf("Ticket release rate : "+(100-(cli.getTicketReleaseRate()/10))+"\n"));
            file.write(String.valueOf("Customer retrieve rate : "+(100-(cli.getCustomerRetrievalRate()/10))+"\n"));
            file.write(String.valueOf("Max ticket capacity : "+cli.getMaxTicketCapacity()+"\n"));
            file.write("------------------------\n");
            System.out.println("Details saved to the file successfully.");
        }catch(IOException e){
            System.out.println("An error found "+e.getMessage());
        }
    }

    public static synchronized void log(String message) {
        try (FileWriter file = new FileWriter("System_Details.txt", true)) {
            file.write(message + "\n");
        } catch (IOException e) {
            System.out.println("Failed to log message: " + e.getMessage());
        }

    }



}
