package br.com.apiCliente.services;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import br.com.apiCliente.modules.client.services.CreateClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateClientServiceTest {

    @Test
    public void createdNewClient(){
        //criar um novo cliente
        Client client = new Client();

        client.setNome("Nome do cliente");
        client.setCpf("Cpf do cliente");
        client.setDataNascimento("01/01/2001");

        //criar um repositorio para o cliente
        ClientRepository repository;

        // criar um novo service
        CreateClientService createClientService = new CreateClientService(repository);
        Client createdClient = createClientService.execute(client);

        assertNotNull(createdClient.getId());
    }

    @Test(expected = Error.class)
    public void createdNotBeNewClientIfExists(){
        Client client = new Client();
        client.setNome("Nome do cliente");
        client.setCpf("Cpf do cliente");
        client.setDataNascimento("01/01/2001");

        ClientRepository repository;
        CreateClientService createClientService = new CreateClientService(repository);
        createClientService.execute(client);
        createClientService.execute(client);
    }
}
