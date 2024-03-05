package br.com.apiCliente;

import br.com.apiCliente.modules.client.entities.Client;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiClienteApplication.class, args);

		try(MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")){
			MongoDatabase database = mongoClient.getDatabase("meuBDCliente");
			MongoCollection<Document> collection = database.getCollection("ClienteApi");

			Document doc = new Document("name", "Fanaina").append("cpf", "123456789-10").append("dataNascimento", "01/01/2001");
			collection.insertOne(doc);
		}
	}

}
