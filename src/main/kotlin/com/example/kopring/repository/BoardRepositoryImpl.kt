package com.example.kopring.repository

import com.example.kopring.domain.Board
import com.example.kopring.domain.QBoard
import com.example.kopring.domain.QBoard.*
import com.example.kopring.domain.QMember
import com.example.kopring.domain.QMember.member
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.jpa.impl.JPAQueryFactory

class BoardRepositoryImpl(
    private val jpaQueryFactory: JPAQueryFactory
) : BoardRepositoryCustom {

    override fun findBoardByFiltering(title: String?, writer : String?): List<Board> {
        return jpaQueryFactory.selectFrom(board)
            .join(board.writer, member)
            .fetchJoin()
            .where(titleContain(title), writerContain(writer))
            .fetch()
    }

    private fun titleContain(title : String?) : BooleanExpression? {
        return title?.let {board.title.contains(title)}
    }

    private fun writerContain(writer : String?) : BooleanExpression? {
        return writer?.let { board.writer.name.contains(writer)}
    }
}