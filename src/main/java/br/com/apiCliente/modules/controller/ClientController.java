package br.com.apiCliente.modules.controller;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import br.com.apiCliente.modules.client.services.CreateClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @PostMapping("/")
    public Client createClient(@RequestBody Client client){
        CreateClientService createClientService = new CreateClientService(repository);
        return createClientService.execute(client);
    }
}
