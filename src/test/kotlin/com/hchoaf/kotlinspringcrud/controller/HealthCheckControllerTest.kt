package com.hchoaf.kotlinspringcrud.controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print

@WebMvcTest(HealthCheckController::class)
internal class HealthCheckControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun healthCheck() {
        // mockMvc mocks and performs the HTTP requests
        // Here print() prints the response, and other parts like status() or content() is used to receive those from response and check with assertion
        mockMvc.perform(get("/ping")).andDo(print()).andExpect(status().isOk).andExpect(content().string("Pong"))
    }
}