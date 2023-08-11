package com.hchoaf.kotlinspringcrud.service

import com.hchoaf.kotlinspringcrud.repository.UserRepository
import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.stereotype.Service

@Service
class UserService(val userRepository: UserRepository) {
    fun addUser(user: User) : Long {
        userRepository.save(user)
        return user.getId()
    }

    fun getUserById(id: Long) : User? {
        return userRepository.findById(id)
    }

    fun getUserByName(name: String) : List<User>? {
        return userRepository.findByName(name)
    }
    fun isUserDuplicate(user: User) : Boolean {
        return (userRepository.findById(user.getId()) == null)
    }


}