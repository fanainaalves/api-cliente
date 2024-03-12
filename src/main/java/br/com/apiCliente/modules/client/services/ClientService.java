package br.com.apiCliente.modules.client.services;

import br.com.apiCliente.modules.client.dto.ClientDTO;
import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public List<ClientDTO> findAll(){
        List<Client> listEntity = clientRepository.findAll();
        List<ClientDTO> listDTO = listEntity.stream().map(e -> new ClientDTO(e)).toList();
        return listDTO;
    }

    public ClientDTO create(ClientDTO entity){
        Client client = new Client(entity);
        clientRepository.save(client);
        ClientDTO clientDTO = new ClientDTO(client);
        return clientDTO;
    }

    public ClientDTO findById(String id){
        Client client = clientRepository.findById(id).get();
        ClientDTO clientDTO = new ClientDTO(client);
        return clientDTO;
    }

    public ClientDTO update(String id, ClientDTO clientDTO){
        Client entity = clientRepository.findById(id).get();
        entity.setNome(clientDTO.getNome());
        /*entity.setCpf(clientDTO.getCpf());
        entity.setEmail(clientDTO.getEmail());
        entity.setTelefone(clientDTO.getTelefone());
        entity.setDataNascimento(clientDTO.getDataNascimento());
        */
        clientRepository.save(entity);
        ClientDTO newClientDTO = new ClientDTO(entity);
        return newClientDTO;
    }

    public void delete(String id){
        Client entity = clientRepository.findById(id).get();
        clientRepository.delete(entity);
    }
}
