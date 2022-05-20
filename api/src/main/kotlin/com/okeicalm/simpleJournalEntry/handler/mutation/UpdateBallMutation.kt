package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.BallType
import com.okeicalm.simpleJournalEntry.usecase.ball.BallUpdateUseCase
import com.okeicalm.simpleJournalEntry.usecase.ball.BallUpdateUseCaseInput
import org.springframework.stereotype.Component

data class UpdateBallInput(val id: ID, val name: String, val size: Int, val price: Int)

@Component
class UpdateBallMutation(private val ballUpdateUseCase: BallUpdateUseCase) : Mutation {
    fun updateBall(input: UpdateBallInput): BallType {
        val output = ballUpdateUseCase.call(
            BallUpdateUseCaseInput(
                id = input.id.toString().toLong(),
                name = input.name,
                size = input.size,
                price = input.price,
            )
        )
        return BallType(output.ball)
    }
}
