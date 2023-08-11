package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User
import org.springframework.stereotype.Repository
import java.lang.IllegalArgumentException
@Repository
class MemoryUserRepository : UserRepository {
    private val users : MutableMap<Long, User> = mutableMapOf()
    private var idSequence : Long = 0L;

    override fun save(user: User) {
        user.setId(idSequence++)
        if(!users.containsKey(user.getId())) {
            users[user.getId()] = user
        } else {
            throw IllegalArgumentException("User already exists!")
        }
    }

    override fun findById(id: Long): User? {
        return users[id]
    }

    override fun findByName(name: String): List<User>? {
        return users.values.stream().filter { u -> u.name.equals(name) }.toList()
    }

    override fun findAll(): List<User> {
        return users.values.toList()
    }
}