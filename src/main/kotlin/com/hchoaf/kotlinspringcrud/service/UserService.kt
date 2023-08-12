package com.hchoaf.kotlinspringcrud.service

import com.hchoaf.kotlinspringcrud.repository.UserRepository
import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {

    fun register(user : User): User {
        return userRepository.save(user)
    }



    fun findUserById(id : Long) : User? {
        return userRepository.getReferenceById(id)
    }

    fun findUserByUsername(username : String) : User? {
        return userRepository.findByUsername(username)
    }

    fun findUserByNickname(nickname: String) : User? {
        return userRepository.findByNickname(nickname)
    }

    fun isUsernameDupliate(username: String) : Boolean {
        return (userRepository.findByUsername(username) != null)
    }

    fun isNicknameDuplicate(nickname: String) : Boolean {
        return (userRepository.findByNickname(nickname) != null)
    }



}