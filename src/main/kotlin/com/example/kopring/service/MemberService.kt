package com.example.kopring.service

import com.example.kopring.domain.Member
import com.example.kopring.dto.member.MemberJoinDto
import com.example.kopring.repository.MemberRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(private val memberRepository: MemberRepository) {

    fun join(requestDto : MemberJoinDto){
        val member = Member(requestDto.loginId, requestDto.name)
        memberRepository.save(member);
    }

}