package com.hchoaf.kotlinspringcrud.service

import com.hchoaf.kotlinspringcrud.repository.UserRepository
import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun register(username: String, password: String): User {
        return userRepository.save(User(username, password))
    }
    fun getUser(id : Long) : User? {
        return userRepository.findById(id).orElse(null)
    }
    fun findUserByUsername(username : String) : User? {
        return userRepository.findByUsername(username)
    }

    fun isUsernameDupliate(username: String) : Boolean {
        return (userRepository.findByUsername(username) != null)
    }

}