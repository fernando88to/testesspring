package com.fernando.testesspring.controllers

import com.fernando.testesspring.dtos.People
import groovy.transform.CompileStatic
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/index')
@CompileStatic
class IndexController {


    @GetMapping
    ResponseEntity<String> index2() {
        return ResponseEntity.ok('Hello word8')
    }

    @GetMapping('/list')
    ResponseEntity<List<People>> list() {
        List<People> peopleList = []
        peopleList+= new People(name:'fernando', email:'fernando88to@gmail.com');
        return ResponseEntity.ok(peopleList)
    }


}
