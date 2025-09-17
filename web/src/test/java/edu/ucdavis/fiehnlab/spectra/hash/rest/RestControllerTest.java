package edu.ucdavis.fiehnlab.spectra.hash.rest;

import io.restassured.RestAssured;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.Disabled;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RestControllerTest {

    private MockMvc mockMvc;

    private String spectra = "{\n" +
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

    @Autowired
    private WebApplicationContext context;


    @LocalServerPort
    int port;

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context).build();
        RestAssuredMockMvc.standaloneSetup(mockMvc);

        RestAssured.port = port;
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {

    }

    @org.junit.jupiter.api.Test
    @Disabled
    public void testConvert() throws Exception {

        given().log().all()
                .contentType("application/json")
                .body(spectra)
                .when()
                .post("/splash/it")
                .then().log().all().statusCode(HttpStatus.OK.value());
    }

    @org.junit.jupiter.api.Test
    @Disabled
    public void testConvert2() throws Exception {

        given().log().all()
                .contentType("application/json")
                .body(spectra)
                .when()
                .post("/splash/it")
                .then().log().all().statusCode(HttpStatus.OK.value());
    }

}