package br.com.apiCliente.modules.client.repositories;

import br.com.apiCliente.modules.client.entities.Client;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {

}
