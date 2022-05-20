package com.okeicalm.simpleJournalEntry.handler.mutation

import com.expediagroup.graphql.generator.scalars.ID
import com.expediagroup.graphql.server.operations.Mutation
import com.okeicalm.simpleJournalEntry.handler.type.BallType
import com.okeicalm.simpleJournalEntry.usecase.ball.BallDeleteUseCase
import com.okeicalm.simpleJournalEntry.usecase.ball.BallDeleteUseCaseInput
import org.springframework.stereotype.Component

data class DeleteBallInput(val id: ID)

@Component
class DeleteBallMutation(private val ballDeletionUseCase: BallDeleteUseCase) : Mutation {
    fun deleteBall(input: DeleteBallInput): BallType {
        val output = ballDeletionUseCase.call(BallDeleteUseCaseInput(id = input.id.toString().toLong()))
        return BallType(output.ball)
    }
}
