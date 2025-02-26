package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Account

interface AccountRepository {
    fun findAll(): List<Account>

    fun findById(id: Long): Account?

    fun create(account: Account): Long

    fun update(id: Long, account: Account): Long

    fun delete(id: Long): Long
}
