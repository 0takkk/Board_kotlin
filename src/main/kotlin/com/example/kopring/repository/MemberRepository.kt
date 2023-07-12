package com.example.kopring.repository

import com.example.kopring.domain.Member
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MemberRepository : JpaRepository<Member, Long>{

    fun existsByLoginId(loginId : String) : Boolean

}