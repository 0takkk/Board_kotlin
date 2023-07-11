package com.example.kopring.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Board (
    var title:String,
    var content:String,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Long? = null,
    var hit:Int = 0
) : BaseEntity()