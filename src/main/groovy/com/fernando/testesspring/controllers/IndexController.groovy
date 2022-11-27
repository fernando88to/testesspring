package com.fernando.testesspring.controllers

import com.fernando.testesspring.dtos.People
import com.fernando.testesspring.spring.RegraNegocioService
import groovy.transform.CompileStatic
import org.springframework.beans.factory.annotation.Autowired
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
    ResponseEntity<List<People>> list() {
        List<People> peopleList = []
        peopleList += new People(name:'fernando', email:'fernando88to@gmail.com');
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
