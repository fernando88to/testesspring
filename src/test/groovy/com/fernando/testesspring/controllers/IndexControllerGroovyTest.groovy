package com.fernando.testesspring.controllers

import com.fernando.testesspring.spring.RegraNegocioService
import groovy.json.JsonSlurper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals

@SpringBootTest
@AutoConfigureMockMvc
class IndexControllerGroovyTest {

    @Autowired
    private MockMvc mvc

    @MockBean
    private RegraNegocioService regraNegocioService

    @Test
    @DisplayName('Testa a listagem')
    void testList() throws Exception {
        //given:
        def url = '/index/list'
        def parser = new JsonSlurper()
        //when:
        def retorno = mvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse()
        String retornoString = retorno.getContentAsString()
        def json = parser.parseText(retornoString)
        //then:
        assertEquals(retorno.status, 200)
        assertEquals(json[0].name, 'fernando')


    }

    @Test
    @DisplayName('Test')
    void testindex4() throws Exception {
        //given:
        def url = '/index/4'
        when(regraNegocioService.getNome()).thenReturn('fernando');
        //when:
        def retorno = mvc.perform(MockMvcRequestBuilders.get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn().getResponse()
        String retornoString = retorno.getContentAsString()

        //then:
        assertEquals(retornoString, 'fernando')


    }
}
