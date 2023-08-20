package com.hchoaf.kotlinspringcrud.repository

import com.hchoaf.kotlinspringcrud.entity.User
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest @Autowired constructor(
    val entityManager: TestEntityManager,
    val userRepository: UserRepository
){
    private val username = "johnDoe"
    private val password = "password1234"

    @Test
    fun `when find by username then return user if exists` (){
        val user = User(username, password)
        entityManager.persist(user)
        entityManager.flush()
        val actual = userRepository.findByUsername(username)
        assertThat(actual).isEqualTo(user)
    }

    @Test
    fun `when find by not existing username then return null`() {
        val actual = userRepository.findByUsername("nonexistingname")
        assertThat(actual).isNull()
    }
}