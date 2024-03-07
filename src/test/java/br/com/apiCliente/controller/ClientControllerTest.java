package br.com.apiCliente.controller;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import br.com.apiCliente.modules.client.services.ClientController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ClientControllerTest {

    @Test
    public void createdNewClient(){
//        //criar um novo cliente
//        Client client = new Client();
//
//        client.setNome("Nome do cliente");
//        client.setCpf("Cpf do cliente");
//        client.setDataNascimento("01/01/2001");
//
//        //criar um repositorio para o cliente
//        ClientRepository repository;
//
//        // criar um novo service
//        ClientController clientController = new ClientController(repository);
//        Client createdClient = clientController.execute(client);
//
//        assertNotNull(createdClient.getId());
    }

    @Test
    public void createdNotBeNewClientIfExists(){
//        Client client = new Client();
//        client.setNome("Nome do cliente");
//        client.setCpf("Cpf do cliente");
//        client.setDataNascimento("01/01/2001");
//
//        ClientRepository repository;
//        ClientController clientController = new ClientController(repository);
//        clientController.execute(client);
//        clientController.execute(client);
    }
}
