package com.okeicalm.simpleJournalEntry.handler.type

import com.expediagroup.graphql.generator.annotations.GraphQLName
import com.expediagroup.graphql.generator.scalars.ID
import com.okeicalm.simpleJournalEntry.entity.Ball

const val ballTypeGraphQLName = "Ball"

@GraphQLName(ballTypeGraphQLName)
data class BallType(
    val id: ID,
    val name: String,
    val size: Int,
    val price: Int,
) {
    constructor(ball: Ball) : this(
        ID(ball.id.toString()),
        ball.name,
        ball.size,
        ball.price,
    )
}
