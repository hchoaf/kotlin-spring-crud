package com.hchoaf.kotlinspringcrud.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User {

    @Id
    val id: Long = TODO("initialize me")

    var name: String

    var age: Int
}