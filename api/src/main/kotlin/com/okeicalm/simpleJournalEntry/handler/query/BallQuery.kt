package com.okeicalm.simpleJournalEntry.handler.query

import com.expediagroup.graphql.server.operations.Query
import com.okeicalm.simpleJournalEntry.handler.type.BallType
import com.okeicalm.simpleJournalEntry.repository.BallRepository
import org.springframework.stereotype.Component

@Component
class BallQuery(private val repository: BallRepository) : Query {
    fun allBalls(): List<BallType> {
        return repository.findAll().map { BallType(it) }
    }
}
