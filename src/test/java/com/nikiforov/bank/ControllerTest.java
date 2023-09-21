package com.nikiforov.bank;

import com.nikiforov.bank.controllers.ClientController;
import com.nikiforov.bank.model.ClientEntity;
import com.nikiforov.bank.repositories.ClientRepository;
import com.nikiforov.bank.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ControllerTest {

    @Test
    void shouldToggleAndDelete() {

        ClientService clientService = Mockito.mock(ClientService.class);

        doNothing().when(clientService).deleteClient(anyLong());
        ClientController cl = new ClientController();
        cl.setClientService(clientService);
        cl.setFeatureToggleDeleteClient(true);
        cl.deleteClient(1l);
        verify(clientService,times(1)).deleteClient(anyLong());


    }
    @Test
    void shouldToggleAndThrow405() {

        ClientService clientService = Mockito.mock(ClientService.class);
        doNothing().when(clientService).deleteClient(anyLong());
        ClientController cl = new ClientController();
        cl.setClientService(clientService);
        cl.setFeatureToggleDeleteClient(false);
        Assertions.assertThrows(ResponseStatusException.class,()->cl.deleteClient(1l));
        verify(clientService,times(0)).deleteClient(anyLong());
    }
}
