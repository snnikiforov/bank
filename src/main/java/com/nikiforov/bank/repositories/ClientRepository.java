package com.nikiforov.bank.repositories;

import com.nikiforov.bank.model.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientEntity,Long> {

}
