package com.nikiforov.bank.controllers;
import com.nikiforov.bank.dto.Client;
import com.nikiforov.bank.model.ClientEntity;
import com.nikiforov.bank.services.ClientService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/client")
@Data
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public ClientEntity getClient(@PathVariable long id) {
        return clientService.getClient(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public long createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void updateClient(@RequestBody Client client) {
        clientService.updateClient(client);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
    }
}