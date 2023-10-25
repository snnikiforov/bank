package com.nikiforov.bank.services;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import com.nikiforov.bank.dto.Client;
import com.nikiforov.bank.model.ClientEntity;
import com.nikiforov.bank.repositories.ClientRepository;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.InterpreterRuleContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@AllArgsConstructor
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public ClientEntity getClient(Long id) {
        ClientEntity cl = clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент не найден с таким айди"));
        cl.setHashPassword("***");
        return cl;
    }

    public long createClient(Client client) {
       return clientRepository.save(new ClientEntity(null, client.getFio(),client.getUserName(),client.getEMail(), client.GetHashPassword())).getId();

    }

    public void updateClient(Client client) {

        ClientEntity cl = getClient(client.getId());
        cl.setFio(client.getFio());
        cl.setEMail(client.getEMail());
        cl.setUserName(client.getUserName());
        if (client.getPassword()!= null) {
            cl.setHashPassword(client.GetHashPassword());
        }

        clientRepository.save(cl);
    }


    public void deleteClient(Long id) {
        clientRepository.deleteById(id);

    }

}
