package com.example.kopring.repository

import com.example.kopring.domain.Board

interface BoardRepositoryCustom {

    fun findBoardByFiltering(title : String?, writer : String?) : List<Board>
}