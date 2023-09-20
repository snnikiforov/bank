package com.nikiforov.bank;

import com.nikiforov.bank.dto.Client;
import com.nikiforov.bank.model.ClientEntity;
import com.nikiforov.bank.repositories.ClientRepository;
import com.nikiforov.bank.services.ClientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

//@SpringBootTest
class BankApplicationTests {

	@Test
	void shouldReturnClient() {
		ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
		ClientEntity client = new ClientEntity(1l,"fioTest");
		when( clientRepository.findById(anyLong())).thenReturn(Optional.of(client));
		ClientService cl = new ClientService(clientRepository);
		ClientEntity result = cl.getClient(client.getId());

		Assertions.assertEquals(result,client);


	}
	@Test
	void shouldThrow404() {
		ClientRepository clientRepository = Mockito.mock(ClientRepository.class);
		ClientEntity client = new ClientEntity(1l,"fioTest");
		when( clientRepository.findById(anyLong())).thenThrow(new ResponseStatusException(HttpStatus.NOT_FOUND, "Клиент не найден с таким айди"));
		ClientService cl = new ClientService(clientRepository);
		//ClientEntity result = cl.getClient(client.getId());

		Assertions.assertThrows(ResponseStatusException.class,()->cl.getClient(client.getId()));

	}

}
