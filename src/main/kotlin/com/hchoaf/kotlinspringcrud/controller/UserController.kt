package com.hchoaf.kotlinspringcrud.controller

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/user")
    fun getUser(@RequestParam("id") id: Int ) : ResponseEntity<String> {
        return ResponseEntity<String>("", HttpStatusCode.valueOf(404))
    }
}