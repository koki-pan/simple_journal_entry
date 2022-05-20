package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Ball

interface BallRepository {
    fun findAll(): List<Ball>

    fun findById(id: Long): Ball?

    fun create(ball: Ball): Ball?

    fun update(id: Long, ball: Ball): Ball?

    fun delete(id: Long): Long
}
