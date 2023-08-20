package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long>{
    fun findByUsername(username : String) : User?
}