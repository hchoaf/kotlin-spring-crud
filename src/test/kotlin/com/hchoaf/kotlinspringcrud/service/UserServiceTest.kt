package com.hchoaf.kotlinspringcrud.service

import com.hchoaf.kotlinspringcrud.entity.User
import com.hchoaf.kotlinspringcrud.repository.UserRepository
import io.mockk.every
import org.junit.jupiter.api.Test
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat


internal class UserServiceTest {
    private val mockUserRepository = mockk<UserRepository>()
    private val userService = UserService(mockUserRepository)

    private val username = "username"
    private val password = "password1234"
    private var user = User(username, password)

    @Test
    fun `if register a user should return the user`() {
        every { mockUserRepository.save(any()) } returns user
        val actual = userService.register(username, password)
        assertThat(actual).isEqualTo(user)
    }

    @Test
    fun `if username is duplicate return true` () {

    }

    @Test
    fun `if username is not duplicate return false` () {

    }
}