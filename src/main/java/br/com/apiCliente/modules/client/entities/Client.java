package br.com.apiCliente.modules.client.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Document(collection = "ClienteAPI")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String cpf;
    private String dataNascimento;

}
