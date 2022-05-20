package com.okeicalm.simpleJournalEntry.usecase.ball

import com.okeicalm.simpleJournalEntry.entity.Ball
import com.okeicalm.simpleJournalEntry.repository.BallRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class BallCreateUseCaseInput(val name: String, val size: Int, val price: Int)
data class BallCreateUseCaseOutput(val ball: Ball)

interface BallCreateUseCase {
    fun call(input: BallCreateUseCaseInput): BallCreateUseCaseOutput
}

@Service
class BallCreateUseCaseImpl(private val ballRepository: BallRepository) : BallCreateUseCase {
    @Transactional
    override fun call(input: BallCreateUseCaseInput): BallCreateUseCaseOutput {
        val ball = Ball(
            name = input.name,
            size = input.size,
            price = input.price
        )
        val newBallId = ballRepository.create(ball)
        val newBall = ballRepository.findById(newBallId) ?: throw Exception("BallCreateUseCase: Something wrong...")
        return BallCreateUseCaseOutput(newBall)
    }
}
