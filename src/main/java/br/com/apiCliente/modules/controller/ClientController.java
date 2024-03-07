package br.com.apiCliente.modules.controller;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @RequestMapping(value = "/clientes")
    public List<Client> findAllClienta(){
        return repository.findAll();
    }
}
