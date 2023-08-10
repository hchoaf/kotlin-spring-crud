package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User

interface UserRepository {
    fun save(user: User)

    fun findById(id: Long) : User?

    fun findByName(name: String) : List<User>?

    fun findAll() : List<User>?
}