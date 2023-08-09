package com.hchoaf.kotlinspringcrud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping

@SpringBootApplication
class KotlinSpringCrudApplication {
}

fun main(args: Array<String>) {
    runApplication<KotlinSpringCrudApplication>(*args)
}
