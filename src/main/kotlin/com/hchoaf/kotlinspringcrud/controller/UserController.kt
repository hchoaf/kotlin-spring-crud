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
            user = userService.findUserById(id)
            returnUserResponseEntity(user!!)
        } catch (e : Exception) {
            returnUserNotFoundResponseEntity()
        }
    }
    /*
    @GetMapping("/user")
    fun getUserByUsername(@RequestParam("username") username: String ) : ResponseEntity<String> {
        val user = userService.findUserByUsername(username)
        return if (user == null) {
            returnUserNotFoundResponseEntity()
        }else {
            returnUserResponseEntity(user)
        }
    }

     */

    @PostMapping("/user/new")
    fun addUser(@RequestParam username : String, @RequestParam nickname: String, @RequestParam password: String) : ResponseEntity<String> {
        val user = User(username, password, nickname)
        return try {
            userService.register(user)
            return returnUserResponseEntity(user)
        } catch (e: Exception) {
            ResponseEntity<String>("User already exists!", HttpStatusCode.valueOf(404))
        }
    }

    fun returnUserResponseEntity(user : User) : ResponseEntity<String> {
        return ResponseEntity<String>(
            "Id : ${user.getId()} | Username : ${user.username} | Password : ${user.password} | Nickname : ${user.nickname}",
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