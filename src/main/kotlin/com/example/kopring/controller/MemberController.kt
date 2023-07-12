package com.example.kopring.controller

import com.example.kopring.common.response.ResponseService
import com.example.kopring.common.result.Result
import com.example.kopring.dto.member.MemberJoinDto
import com.example.kopring.service.MemberService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/member")
class MemberController(
    private val memberService: MemberService,
    private val responseService: ResponseService
){

    @PostMapping
    fun join(@RequestBody requestDto : MemberJoinDto) : Result{
        memberService.join(requestDto)
        return responseService.getSuccessResult()
    }
}