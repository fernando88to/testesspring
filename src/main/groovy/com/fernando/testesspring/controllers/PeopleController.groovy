package com.fernando.testesspring.controllers

import com.fernando.testesspring.entities.People
import com.fernando.testesspring.repositories.PeopleRepository
import groovy.transform.CompileStatic
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping('/people')
@CompileStatic
class PeopleController {

    PeopleRepository peopleRepository

    PeopleController(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository
    }

    @GetMapping('/save')
    ResponseEntity<String> save() {
        peopleRepository.save(new People(name:'fernando'))
        return ResponseEntity.ok('foi')
    }


    @GetMapping('/list')
    ResponseEntity<List<People>> list2() {
        def list = peopleRepository.findAll().toList()
        return ResponseEntity.ok(list)
    }
}
