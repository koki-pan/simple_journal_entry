package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Ball

interface BallRepository {
    fun findAll(): List<Ball>

    fun findById(id: Long): Ball?

    fun create(ball: Ball): Long

    fun update(id: Long, ball: Ball): Long

    fun delete(id: Long): Long
}
