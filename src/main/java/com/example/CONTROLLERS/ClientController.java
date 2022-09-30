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

    @GetMapping(path = "/all/active")
    public ResponseEntity<List<Client>> getActiveClients(){
        List<Client> clients = clientService.findActiveClients();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Client>> getAllClients(){
        List<Client> clients = clientService.findAllClients();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }
    @GetMapping(path = "/all/removed")
    public ResponseEntity<List<Client>> getRemovedClients(){
        List<Client> clients = clientService.findRemovedClients();
        return new ResponseEntity<>(clients,HttpStatus.OK);
    }

@PutMapping(path = "/update")
public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client client1 = clientService.updateClient(client);
        return new ResponseEntity<Client>(client1,HttpStatus.OK);
}
    @PostMapping(path = "/add")
    public ResponseEntity<Client> addClient(@RequestBody Client client){
        client.setActive(true);
        Client client1 = clientService.addClient(client);

        return new ResponseEntity<>(client1, HttpStatus.CREATED);
    }
    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<Client> deleteClient(@PathVariable("id") Long id){
        clientService.deleteClient(id);
        return new ResponseEntity<>(HttpStatus.OK);
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
@PutMapping(path = "/remove")
public ResponseEntity<Client> deactivateClient(@RequestBody Client client2){
        client2.setActive(false);
        clientService.updateClient(client2);
        return new ResponseEntity<Client>(client2,HttpStatus.OK);
}
}
