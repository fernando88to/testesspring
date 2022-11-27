package com.fernando.testesspring.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerTest {
    @Autowired
    private MockMvc mvc;


    @Test
    void meuTeste() throws Exception {
        String contentAsString = mvc.perform(MockMvcRequestBuilders.get("/index"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        assertEquals(contentAsString, "Hello word8");

    }

    @Test
    void meuTeste2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/index/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists());
                //.andExpect(MockMvcResultMatchers.jsonPath("$.employees[*].employeeId").isNotEmpty());

    }

    /*void "when get is performed then the response has status 200 and content is 'Hello world!'"() {
        expect: "Status is 200 and the response is 'Hello world!'"
        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn().response.contentAsString == "Hello world!"
    }*/


}