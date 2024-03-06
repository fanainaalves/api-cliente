package br.com.apiCliente.modules.client.services;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;

public class CreateClientService {

    private ClientRepository repository;
    public CreateClientService(ClientRepository repository){
        this.repository = repository;
    }

    public Client execute(Client client){
        Client existedClient = this.repository.findByName(client.getNome());
        if(existedClient != null){
            throw new Error("O cliente já existe!");
        }
        return repository.save(client);
    }
}
