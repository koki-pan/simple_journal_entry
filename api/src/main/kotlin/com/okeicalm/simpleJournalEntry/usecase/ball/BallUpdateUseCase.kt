package com.okeicalm.simpleJournalEntry.usecase.ball

import com.okeicalm.simpleJournalEntry.entity.Ball
import com.okeicalm.simpleJournalEntry.repository.BallRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class BallUpdateUseCaseInput(val id: Long, val name: String, val size: Int, val price: Int)
data class BallUpdateUseCaseOutput(val ball: Ball)

interface BallUpdateUseCase {
    fun call(input: BallUpdateUseCaseInput): BallUpdateUseCaseOutput
}

@Service
class BallUpdateUseCaseImpl(private val ballRepository: BallRepository) : BallUpdateUseCase {
    @Transactional
    override fun call(input: BallUpdateUseCaseInput): BallUpdateUseCaseOutput {
        val ball = Ball(
            name = input.name, size = input.size, price = input.price
        )
        ballRepository.update(input.id, ball)

        val updatedBall = ballRepository.findById(input.id) ?: throw Exception("BallUpdateUseCase: Something wrong...")
        return BallUpdateUseCaseOutput(updatedBall)
    }
}
