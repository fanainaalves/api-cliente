package br.com.apiCliente.modules.client.services;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public Client create(Client entity){
        return clientRepository.save(entity);
    }

    public Client findById(String id){
        return clientRepository.findById(id).get();
    }

    public Client update(String id, Client client){
        Client entity = clientRepository.findById(id).get();
        entity.setNome(client.getNome());
        entity.setCpf(client.getCpf());
        entity.setEmail(client.getEmail());
        entity.setTelefone(client.getTelefone());
        entity.setDataNascimento(client.getDataNascimento());

        return clientRepository.save(entity);
    }

    public void delete(String id){
        Client entity = clientRepository.findById(id).get();
        clientRepository.delete(entity);
    }
}
