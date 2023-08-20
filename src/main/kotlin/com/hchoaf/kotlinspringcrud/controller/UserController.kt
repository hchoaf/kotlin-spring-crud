package com.hchoaf.kotlinspringcrud.controller

import com.hchoaf.kotlinspringcrud.entity.User
import com.hchoaf.kotlinspringcrud.service.UserService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController (val userService: UserService){
    @GetMapping("/user")
    fun getUserById(@RequestParam("id") id: Long ) : ResponseEntity<String> {
        val user : User?
        return try {
            user = userService.getUser(id)
            returnUserResponseEntity(user!!)
        } catch (e : Exception) {
            returnUserNotFoundResponseEntity()
        }
    }

    @PostMapping("/user/new")
    fun addUser(@RequestParam username : String, @RequestParam password: String) : ResponseEntity<String> {
        return try {
            val user = userService.register(username, password)
            return returnUserResponseEntity(user)
        } catch (e: Exception) {
            ResponseEntity<String>("User already exists!", HttpStatusCode.valueOf(404))
        }
    }

    fun returnUserResponseEntity(user : User) : ResponseEntity<String> {
        return ResponseEntity<String>(
            "Id : ${user.getId()} | Username : ${user.username} | Password : ${user.password}",
            HttpStatusCode.valueOf(200)
        )
    }

    fun returnUserNotFoundResponseEntity() : ResponseEntity<String> {
        return ResponseEntity<String>(
            "User not found",
            HttpStatusCode.valueOf(404)
        )
    }
}