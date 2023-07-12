package com.example.kopring.common.exception

import com.example.kopring.common.exception.member.MemberDuplicationException
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
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    fun memberDuplicationException() : Result{
        return responseService.getFailureResult(-100, "중복된 아이디입니다.")
    }
}