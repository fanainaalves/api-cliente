package br.com.apiCliente.modules.client.entities;

import br.com.apiCliente.modules.client.dto.ClientDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Builder
@Document(collection = "clients")
public class Client implements Serializable {

    @Id
    private String id;
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;

    public Client(){
        super();
    }

    public Client(ClientDTO clientDTO){
        id = clientDTO.getId();
        nome = clientDTO.getNome();
    }

}
