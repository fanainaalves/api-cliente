package br.com.apiCliente.modules.controller;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

    @Autowired
    private ClientRepository repository;

    @GetMapping
    public List<Client> listClients(){
//        return repository.findAll();
        return Arrays.asList(Client.builder()
                .nome("Fanny")
                .email("fanaina@gmail.com")
                .telefone("1111-2222").build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client entity){
        entity.setId(ObjectId.get().toString());
        return repository.save(entity);
    }
}
