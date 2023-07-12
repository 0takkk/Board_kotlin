package com.example.kopring.repository

import com.example.kopring.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface BoardRepository : JpaRepository<Board, Long>{

    @Query("select b from Board b join fetch b.writer w where b.id = :id")
    fun findByIdWithWriter(id : Long) : Board?

}