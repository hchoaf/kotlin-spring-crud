package com.hchoaf.kotlinspringcrud.controller

import com.hchoaf.kotlinspringcrud.entity.User
import com.hchoaf.kotlinspringcrud.service.UserService
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UserController (val userService: UserService){
    @GetMapping("/user")
    fun getUser(@RequestParam("id") id: Long ) : ResponseEntity<String> {
        val user = userService.getUserById(id)
        return if (user == null) {
            ResponseEntity<String>("User not found", HttpStatusCode.valueOf(404))
        } else {
            ResponseEntity<String>("User Id : ${user.getId()} | User Name : ${user.name}", HttpStatusCode.valueOf(200))
        }
    }

    @PostMapping("/user/new")
    fun addUser(@RequestBody name : String) : ResponseEntity<String> {
        val user = User()
        user.setName(name)
        return try {
            userService.addUser(user)
            ResponseEntity<String>("User Id : ${user.getId()} | User Name : ${user.name} \n Successfully Added!", HttpStatusCode.valueOf(200))
        } catch (e: Exception) {
            ResponseEntity<String>("User already exists!", HttpStatusCode.valueOf(404))
        }
    }
}