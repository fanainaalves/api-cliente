package br.com.apiCliente.controller;

import br.com.apiCliente.ApiClienteApplication;
import br.com.apiCliente.ApiClienteApplicationTests;
import br.com.apiCliente.modules.client.dto.ClientDTO;
import br.com.apiCliente.modules.client.entities.Client;
import br.com.apiCliente.modules.controller.ClientController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles("test")
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
    @Order(0)
    public void testCreateClient() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.post("/clients")
                        .content(asJsonString(new ClientDTO(null, "Fanaina")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @Order(1)
    public void testListClient() throws Exception {
        this.mockMvc.perform(get("/clients"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty());
    }

    @Test
    @Order(2)
    public void testFindByID() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/clients/65ef65aeb7757455d89c52a8"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").isNotEmpty())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @Order(3)
    public void testUpdate() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.put("/clients/65ef65aeb7757455d89c52a8")
                .content(asJsonString(new ClientDTO(null,"Maria")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
    }

    @Test
    @Order(4)
    public void testDelete() throws Exception{
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(new ClientDTO(null, "Fanaina")))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                .andReturn();

        String response = result.getResponse().getContentAsString();
        JSONObject jsonObject = new JSONObject(response);
        String clientId = jsonObject.getString("id");

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/clients/" + clientId)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
    }

    @Test
    @Order(5)
    public void testSaveClients(){
        ClientDTO clientDTO = new ClientDTO(null, "Maria");
    }

    public static String asJsonString(final Object obj){
        try{
            return new ObjectMapper().writeValueAsString(obj);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
