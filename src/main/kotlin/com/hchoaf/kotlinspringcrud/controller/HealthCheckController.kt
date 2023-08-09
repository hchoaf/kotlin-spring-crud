package com.hchoaf.kotlinspringcrud.controller

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HealthCheckController {
    @GetMapping("/ping")
    fun healthCheck(): ResponseEntity<String> {
        return ResponseEntity<String>("Pong", HttpStatusCode.valueOf(200))
    }
}