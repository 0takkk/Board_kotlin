package com.example.kopring.service

import com.example.kopring.domain.Member
import com.example.kopring.repository.MemberRepository
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class MemberServiceTest(
    @Autowired private val memberRepository: MemberRepository
){

    @Test
    fun test(){
        val member = memberRepository.save(Member("syt0719", "서영탁") )

        val member1 = memberRepository.findById(member.id).get()
        val member2 = memberRepository.findById(member.id).get()

        assertThat(member1).isEqualTo(member2)
    }
}