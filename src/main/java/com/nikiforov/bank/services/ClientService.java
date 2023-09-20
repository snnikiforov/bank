package com.nikiforov.bank.services;

import com.nikiforov.bank.dto.Client;
import com.nikiforov.bank.model.ClientEntity;
import com.nikiforov.bank.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service

public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity getClient(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент не найден с таким айди"));
    }

    public long createClient(Client client) {
       return clientRepository.save(new ClientEntity(null, client.getFio())).getId();

    }

    public void updateClient(Client client) {
        ClientEntity cl = getClient(client.getId());
        cl.setFio(client.getFio());
        clientRepository.save(cl);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }
}
