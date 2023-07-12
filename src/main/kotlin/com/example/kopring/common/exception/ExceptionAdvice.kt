package com.example.kopring.common.exception

import com.example.kopring.common.exception.board.BoardNotFoundException
import com.example.kopring.common.exception.member.MemberDuplicationException
import com.example.kopring.common.exception.member.MemberNotFoundException
import com.example.kopring.common.response.ResponseService
import com.example.kopring.common.result.Result
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionAdvice(
    private val responseService: ResponseService
) {

    @ExceptionHandler(MemberDuplicationException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun memberDuplicationException() : Result{
        return responseService.getFailureResult(-100, "중복된 아이디입니다.")
    }

    @ExceptionHandler(MemberNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun memberNotFoundException() : Result{
        return responseService.getFailureResult(-101, "존재하지 않은 회원입니다.")
    }

    @ExceptionHandler(BoardNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun boardNotFoundException() : Result{
        return responseService.getFailureResult(-102, "존재하지 않은 게시글입니다.")
    }

}