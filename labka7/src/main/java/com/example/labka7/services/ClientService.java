package com.example.labka7.services;

import com.example.labka7.models.Client;
import com.example.labka7.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public void saveClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int id) {
        return clientRepository.findById(id);
    }

    public void updatePhoneNumber(int clientId, String phoneNumber) {
        clientRepository.updatePhoneNumber(clientId, phoneNumber);
    }

    public void deleteClientById(int id) {
        clientRepository.deleteById(id);
    }

}
