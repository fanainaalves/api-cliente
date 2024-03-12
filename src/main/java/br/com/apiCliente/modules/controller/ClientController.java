package br.com.apiCliente.modules.controller;

import br.com.apiCliente.modules.client.dto.ClientDTO;
import br.com.apiCliente.modules.client.repositories.ClientRepository;
import br.com.apiCliente.modules.client.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    ClientRepository repository;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> listClient(){
        return ResponseEntity.ok(clientService.findAll());
        /*return Arrays.asList(Client.builder()
                .nome("Fanny")
                .email("fanaina@gmail.com")
                .telefone("1111-2222").build());
         */
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO entity){
        //entity.setId(ObjectId.get().toString());
        return ResponseEntity.ok().body(clientService.create(entity));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable String id, @RequestBody ClientDTO entity){
        return ResponseEntity.status(HttpStatus.OK).body(clientService.update(id, entity));
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable String id){
        clientService.delete(id);
    }

}
