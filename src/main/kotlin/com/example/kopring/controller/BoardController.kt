package com.example.kopring.controller

import com.example.kopring.dto.BoardDto
import com.example.kopring.service.BoardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController (private val boardService: BoardService){

    @PostMapping
    fun writeBoard(@RequestBody boardDto: BoardDto){
        boardService.writeBoard(boardDto)
    }




}