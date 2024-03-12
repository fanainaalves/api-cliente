package br.com.apiCliente.modules.controller;

import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import br.com.apiCliente.modules.client.services.ClientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    ClientRepository repository;

    @GetMapping
    public List<Client> listClient(){
        return clientService.findAll();
        /*return Arrays.asList(Client.builder()
                .nome("Fanny")
                .email("fanaina@gmail.com")
                .telefone("1111-2222").build());
         */
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable String id){
        return clientService.findById(id);
    }

    @PostMapping
    public Client createClient(@RequestBody Client entity){
        entity.setId(ObjectId.get().toString());
        return clientService.create(entity);
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable String id, @RequestBody Client entity){
        return clientService.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id){
        clientService.delete(id);
    }

}
