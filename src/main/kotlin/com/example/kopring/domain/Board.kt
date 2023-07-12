package com.example.kopring.domain

import javax.persistence.*

@Entity
class Board (
    var title:String,
    var content:String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    val writer:Member,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    val id : Long = 0,
    var hit:Int = 0
) : BaseEntity() {

    fun addHit(){
        this.hit++
    }

}