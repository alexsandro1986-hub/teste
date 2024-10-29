package com.example.fazenda;

import com.example.fazenda.entities.Fazenda;
import com.example.fazenda.repositories.FazendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FazendaIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FazendaRepository fazendaRepository;

    private ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    void setup() {
        fazendaRepository.deleteAll();
    }

    @Test
    void testCreateFazendaSuccess() throws Exception {
        Fazenda fazenda = new Fazenda(null, "Fazenda Teste", "12345", 100.0, 80.0, 20.0, "12345678901", -23.5505, -46.6333);

        mockMvc.perform(post("/fazendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fazenda)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Fazenda Teste"))
                .andExpect(jsonPath("$.codigo").value("12345"));
    }

    @Test
    void testCreateFazendaWithIncompleteData() throws Exception {
        Fazenda fazenda = new Fazenda(null, null, "54321", null, null, null, "12345678901", null, null);
    
        mockMvc.perform(post("/fazendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fazenda)))
                .andExpect(status().isBadRequest()); 
    }

    @Test
    void testGetFazendaByIdSuccess() throws Exception {
        Fazenda fazenda = fazendaRepository.save(new Fazenda(null, "Fazenda Teste", "12345", 100.0, 80.0, 20.0, "12345678901", -23.5505, -46.6333));

        mockMvc.perform(get("/fazendas/{id}", fazenda.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Fazenda Teste"));
    }

    @Test
    void testGetFazendaByIdNotFound() throws Exception {
        mockMvc.perform(get("/fazendas/{id}", 99999))
                .andExpect(status().isNotFound());
    }

    @Test
    void testUpdateFazendaSuccess() throws Exception {
        Fazenda fazenda = fazendaRepository.save(new Fazenda(null, "Fazenda Teste", "12345", 100.0, 80.0, 20.0, "12345678901", -23.5505, -46.6333));

        fazenda.setNome("Fazenda Atualizada");
        mockMvc.perform(put("/fazendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fazenda)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Fazenda Atualizada"));
    }

    @Test
    void testUpdateFazendaNotFound() throws Exception {
        Fazenda fazenda = new Fazenda(99999L, "Fazenda Inexistente", "54321", 100.0, 80.0, 20.0, "12345678901", -23.5505, -46.6333);

        mockMvc.perform(put("/fazendas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(fazenda)))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteFazendaSuccess() throws Exception {
        Fazenda fazenda = fazendaRepository.save(new Fazenda(null, "Fazenda Teste", "12345", 100.0, 80.0, 20.0, "12345678901", -23.5505, -46.6333));

        mockMvc.perform(delete("/fazendas/{id}", fazenda.getId()))
                .andExpect(status().isNoContent());

        mockMvc.perform(get("/fazendas/{id}", fazenda.getId()))
                .andExpect(status().isNotFound());
    }

    @Test
    void testDeleteFazendaNotFound() throws Exception {
        mockMvc.perform(delete("/fazendas/{id}", 99999))
                .andExpect(status().isNotFound());
    }
}
