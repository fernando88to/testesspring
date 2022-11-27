package com.fernando.testesspring.entities

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id
    @Column(nullable = false)
    String name
}
