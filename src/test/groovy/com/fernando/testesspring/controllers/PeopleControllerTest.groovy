package com.fernando.testesspring.controllers

import com.fernando.testesspring.entities.People
import com.fernando.testesspring.repositories.PeopleRepository;
import com.fernando.testesspring.spring.RegraNegocioService
import groovy.json.JsonSlurper
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PeopleControllerTest {

    @Autowired
    private MockMvc mvc

    @MockBean
    private PeopleRepository peopleRepository


    @Test
    void testList() {
        //given:
        def parser = new JsonSlurper()
        def url = '/people/list'
        List<People> peopleList = []
        peopleList += new People(id:1, name:'fernando h')
        when(peopleRepository.findAll()).thenReturn(peopleList)
        //when:
        def retorno = mvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse()
        String retornoString = retorno.getContentAsString()
        def json = parser.parseText(retornoString)
        //then:
        assertEquals(retorno.status, 200)
        assertEquals(json[0].name, 'fernando h')
        assertEquals(json[0].id, 1)

    }

}