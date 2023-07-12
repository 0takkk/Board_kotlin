package com.example.kopring.service

import com.example.kopring.common.exception.member.MemberNotFoundException
import com.example.kopring.domain.Board
import com.example.kopring.dto.board.BoardDto
import com.example.kopring.repository.BoardRepository
import com.example.kopring.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService (
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository
){

    fun writeBoard(boardDto: BoardDto) {
        val writer = memberRepository.findByIdOrNull(boardDto.writerId) ?: throw MemberNotFoundException()
        val board = Board(boardDto.title, boardDto.content, writer)
        boardRepository.save(board)
    }
}