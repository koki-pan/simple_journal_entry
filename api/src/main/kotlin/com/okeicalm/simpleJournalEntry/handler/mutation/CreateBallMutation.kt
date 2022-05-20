package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.BallType
import com.okeicalm.simpleJournalEntry.usecase.ball.BallCreateUseCase
import com.okeicalm.simpleJournalEntry.usecase.ball.BallCreateUseCaseInput
import org.springframework.stereotype.Component

data class CreateBallInput(val name: String, val size: Int, val price: Int)

@Component
class CreateBallMutation(private val ballCreateUseCase: BallCreateUseCase) : Mutation {
    fun createBall(input: CreateBallInput): BallType {
        val output = ballCreateUseCase.call(
            BallCreateUseCaseInput(
                name = input.name,
                size = input.size,
                price = input.price,
            )
        )
        return BallType(output.ball)
    }
}
