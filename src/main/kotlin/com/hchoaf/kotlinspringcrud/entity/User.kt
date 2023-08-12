package com.hchoaf.kotlinspringcrud.entity

import jakarta.persistence.*

@Entity
@Table(name="User-Database")
open class User() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long = 0L

    constructor(username: String, password: String, nickname: String) : this() {
        this.username = username
        this.password = password
        this.nickname = nickname
    }

    var username : String? = null
        protected set

    var password: String? = null
        protected set

    var nickname: String? = null
        protected set

    fun getId() : Long {
        return this.id
    }
    override fun toString() : String {
        return "$id | $username | $password | $nickname";
    }

}