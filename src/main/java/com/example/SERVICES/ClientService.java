package com.example.SERVICES;

import com.example.MODELS.Client;
import com.example.REPOSITORIES.ClientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    @Autowired
    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    public Client addClient(Client client){   //////////// ADD
        return clientRepo.save(client);
    } //////ADD

    public List<Client> findAllClients(){
        return clientRepo.findAll();
    }  //////GET ALL

    public Client updateClient(Client client){
        return clientRepo.save(client);
    } //////UPDATE Client

    public void deleteAppointment(Long id){
        clientRepo.deleteById(id);
    } //////DELETE BY ID

    public Client findById(Long id){
        return clientRepo.findById(id).orElseThrow();
    } ///FIND BY ID

    public Client findRandomClient(){
        return clientRepo.findRandomClient();
    }
}
