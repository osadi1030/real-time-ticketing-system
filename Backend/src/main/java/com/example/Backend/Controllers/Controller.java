package com.example.Backend.Controllers;

import com.example.Backend.Inputs;
import com.example.Backend.Models.TicketManagementSystem;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

    @PostMapping("/start")
    public void start(@RequestBody Inputs inputs){

        TicketManagementSystem ticketManagementSystem = new TicketManagementSystem();
        try{
            ticketManagementSystem.start(inputs);
        }catch(InterruptedException e){
            throw new RuntimeException();
        }

    }

}
