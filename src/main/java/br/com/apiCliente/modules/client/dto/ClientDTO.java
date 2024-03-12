package br.com.apiCliente.modules.client.dto;

import br.com.apiCliente.modules.client.entities.Client;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO implements Serializable {

    @Id
    private String id;
    private String nome;
    /*
    * Não colocarei esses dados por serem dados sensíveis, e para que nao fiquem expostos na camada de transferência
    *
    * private String cpf;
    * private String dataNascimento;
    * private String email;
    * private String telefone;
    */

    public ClientDTO(Client client){
        id = client.getId();
        nome = client.getNome();
    }

}
