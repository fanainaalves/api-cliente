package br.com.apiCliente.controller;

import br.com.apiCliente.ApiClienteApplicationTests;
import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.controller.ClientController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class ClientControllerTest extends ApiClienteApplicationTests {


    private MockMvc mockMvc;
    private String id;

    @Autowired
    private ClientController clientController;

    @BeforeEach
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void TestListClient() throws Exception {
        this.mockMvc.perform(get("/clients"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }

    @Test
    public void TestCreateClient() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/clients")
                        .content(asJsonString(new Client(null, "Fanaina", "cpf", "DataNac", "email", "telefone")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testUpdate() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.put("/clients")
                .content(asJsonString(new Client("65eb10c62b02550b026904cc","Fanaina","cpf", "DataNac", "email", "telefone")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    public void testSaveClients(){
        Client client = new Client("1", "Fanaina","cpf", "DataNac", "email", "telefone");
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
