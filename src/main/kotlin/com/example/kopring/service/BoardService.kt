package com.example.kopring.service

import com.example.kopring.domain.Board
import com.example.kopring.dto.BoardDto
import com.example.kopring.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService (private val boardRepository: BoardRepository){

    fun writeBoard(boardDto: BoardDto) {
        val board = Board(boardDto.title, boardDto.content)
        boardRepository.save(board)
    }
}