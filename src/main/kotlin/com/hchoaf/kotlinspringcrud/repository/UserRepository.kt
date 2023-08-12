package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>{
    fun findByUsername(username : String) : User?

    fun findByNickname(nickName : String) : User?

}