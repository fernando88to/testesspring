package com.fernando.testesspring.controllers

import com.fernando.testesspring.dtos.PeopleDTO
import com.fernando.testesspring.spring.RegraNegocioService
import groovy.transform.CompileStatic
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/index')
@CompileStatic
class IndexController {

    RegraNegocioService regraNegocioService

    IndexController(RegraNegocioService regraNegocioService) {
        this.regraNegocioService = regraNegocioService
    }

    @GetMapping
    ResponseEntity<String> index2() {
        return ResponseEntity.ok('Hello word8')
    }

    @GetMapping('/list')
    ResponseEntity<List<PeopleDTO>> list() {
        List<PeopleDTO> peopleList = []
        peopleList += new PeopleDTO(name:'fernando', email:'fernando88to@gmail.com');
        return ResponseEntity.ok(peopleList)
    }

    @GetMapping('/3')
    ResponseEntity<String> index3() {
        return ResponseEntity.ok('Hello word8')
    }

    @GetMapping('/4')
    ResponseEntity<String> index4() {
        String name = regraNegocioService.getNome()
        return ResponseEntity.ok(name)
    }


}
