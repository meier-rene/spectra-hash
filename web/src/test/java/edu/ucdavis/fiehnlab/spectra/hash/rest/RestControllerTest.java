package edu.ucdavis.fiehnlab.spectra.hash.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private final String spectra = "{\n" +
            "\"ions\": [\n" +
            "{\n" +
            "\"mass\": 100,\n" +
            "\"intensity\": 1\n" +
            "},\n" +
            "{\n" +
            "\"mass\": 101,\n" +
            "\"intensity\": 2\n" +
            "},\n" +
            "{\n" +
            "\"mass\": 102,\n" +
            "\"intensity\": 3\n" +
            "}\n" +
            "],\n" +
            "\"metaData\": { }\n," +
            "\"type\": \"MS\"\n" +
            "}";

    @Test
    public void testConvert() throws Exception {
        mockMvc.perform(post("/splash/it")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(spectra))
                .andExpect(status().isOk());
    }

    @Test
    public void testConvert2() throws Exception {
        mockMvc.perform(post("/splash/it")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(spectra))
                .andExpect(status().isOk());
    }

}