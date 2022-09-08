package com.example.CONTROLLERS;

import com.example.CONTROLLERS.RANDOMIZE.RandomFirstNames;
import com.example.CONTROLLERS.RANDOMIZE.RandomLastNames;
import com.example.MODELS.Client;
import com.example.SERVICES.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@CrossOrigin
@RequestMapping(path = "/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }


    @PostMapping(path = "/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        Client client1 = clientService.addClient(client);
        return new ResponseEntity<>(client1, HttpStatus.CREATED);
    }



    @PostMapping(path = "/add_random")
    public ResponseEntity<Client> addRandomClient(){
        Client client =new Client();
        Random random =new Random();
        client.setFirstName(RandomFirstNames.values()[random.nextInt(0,RandomFirstNames.values().length)].toString());
        client.setLastName(RandomLastNames.values()[random.nextInt(0,RandomLastNames.values().length)].toString());
        client.setPhoneNumber("052-"+random.nextInt(1000000,9000000));
        clientService.addClient(client);
        return new ResponseEntity<Client>(client,HttpStatus.CREATED);
    }
}
