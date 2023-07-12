package com.example.kopring.controller

import com.example.kopring.common.response.ResponseService
import com.example.kopring.common.result.Result
import com.example.kopring.dto.board.BoardDto
import com.example.kopring.service.BoardService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/board")
class BoardController (
    private val boardService: BoardService,
    private val responseService: ResponseService
){

    @PostMapping
    fun writeBoard(@RequestBody boardDto: BoardDto) : Result{
        boardService.writeBoard(boardDto)
        return responseService.getSuccessResult()
    }




}