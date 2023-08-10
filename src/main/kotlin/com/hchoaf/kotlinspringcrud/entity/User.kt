package com.hchoaf.kotlinspringcrud.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
class User {

    @Id
    val id: Long = 0L

    var name: String? = null

    @JvmName("getId1")
    fun getId() : Long {
        return id
    }

    @JvmName("setName1")
    fun setName(name: String) {
        this.name = name
    }

    @JvmName("getName1")
    fun getName() : String? {
        return name
    }

}