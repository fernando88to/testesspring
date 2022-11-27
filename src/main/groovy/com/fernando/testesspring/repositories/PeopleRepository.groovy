package com.fernando.testesspring.repositories

import com.fernando.testesspring.entities.People
import org.springframework.data.repository.CrudRepository

interface PeopleRepository extends CrudRepository<People, Integer> {
}
