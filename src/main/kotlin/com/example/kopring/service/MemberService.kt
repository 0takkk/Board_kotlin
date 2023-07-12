package com.example.kopring.service

import com.example.kopring.common.exception.member.MemberDuplicationException
import com.example.kopring.common.exception.member.MemberNotFoundException
import com.example.kopring.domain.Member
import com.example.kopring.dto.member.MemberJoinDto
import com.example.kopring.dto.member.MemberSearchDto
import com.example.kopring.repository.MemberRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(private val memberRepository: MemberRepository) {

    fun join(requestDto : MemberJoinDto){
        checkDuplication(requestDto.loginId)
        val member = Member(requestDto.loginId, requestDto.name)
        memberRepository.save(member);
    }

    @Transactional(readOnly = true)
    fun checkDuplication(loginId : String){
        val isDuplication = memberRepository.existsByLoginId(loginId)
        if(isDuplication) throw MemberDuplicationException()
    }

    @Transactional(readOnly = true)
    fun searchMemberById(id : Long) : MemberSearchDto{
        val member = memberRepository.findByIdOrNull(id) ?: throw MemberNotFoundException()
        return MemberSearchDto(member.loginId, member.name)
    }

}