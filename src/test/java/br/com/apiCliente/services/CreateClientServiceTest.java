package br.com.apiCliente.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CreateClientServiceTest {

    @Test
    public void createdNewClient(){

        //criar um novo cliente
        Client client = new Client();
        client.setName("Nome do cliente");
        client.setCpf("Cpf do cliente");
        client.setDataNascimento("01/01/2001");

        //criar um repositorio para o cliente
        ClientMemoryRepository repository =  new ClientMemoryRepository();

        // criar um novo service
        CreateClientService createClientService = new CreateClientService(repository);
        Client createdClient = createClientService.execute(client);

        assertNotNull(createdClient.getId());
    }

    @Test(expected = Error.class)
    public void createdNotBeNewClientIfExists(){
        Client client = new Client();
        client.setName("Nome do cliente");
        client.setCpf("Cpf do cliente");
        client.setDataNascimento("01/01/2001");

        ClientMemoryRepository repository =  new ClientMemoryRepository();
        CreateClientService createClientService = new CreateClientService(repository);
        createClientService.execute(client);
        createClientService.execute(client);
    }
}
