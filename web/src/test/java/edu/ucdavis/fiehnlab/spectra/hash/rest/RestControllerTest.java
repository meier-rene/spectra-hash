package edu.ucdavis.fiehnlab.spectra.hash.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testConvert() throws Exception {
        mockMvc.perform(post("/splash/it")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"ions\":[{\"mass\":100,\"intensity\":1}],\"type\":\"MS\"}"))
                .andExpect(status().isOk());
    }
}