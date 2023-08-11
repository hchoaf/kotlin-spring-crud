package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User

class MemoryUserRepository : UserRepository {
    private val users : MutableMap<Long, User> = mutableMapOf()

    override fun save(user: User) {
        if(!users.containsKey(user.id)) {
            users[user.id] = user
        }

        TODO("Not yet implemented")
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