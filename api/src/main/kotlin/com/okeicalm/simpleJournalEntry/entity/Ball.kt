package com.okeicalm.simpleJournalEntry.entity

import com.okeicalm.simpleJournalEntry.tables.pojos.Balls

data class Ball(
    val id: Long = 0,
    val name: String,
    val size: Int,
    val price: Int,
) {
    constructor(ball: Balls) : this(
        ball.id,
        ball.name,
        ball.size,
        ball.price,
    )
}
