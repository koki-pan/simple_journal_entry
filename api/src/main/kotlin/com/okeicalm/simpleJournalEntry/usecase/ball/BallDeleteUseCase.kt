package com.okeicalm.simpleJournalEntry.usecase.ball

import com.okeicalm.simpleJournalEntry.entity.Ball
import com.okeicalm.simpleJournalEntry.repository.BallRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

data class BallDeleteUseCaseInput(val id: Long)
data class BallDeleteUseCaseOutput(val ball: Ball)

interface BallDeleteUseCase {
    fun call(input: BallDeleteUseCaseInput): BallDeleteUseCaseOutput
}

@Service
class BallDeleteUseCaseImpl(private val ballRepository: BallRepository) : BallDeleteUseCase {
    @Transactional
    override fun call(input: BallDeleteUseCaseInput): BallDeleteUseCaseOutput {
        val deletedBall = ballRepository.findById(input.id) ?: throw Exception("BallDeleteUseCase: Something wrong...")
        ballRepository.delete(input.id)
        return BallDeleteUseCaseOutput(deletedBall)
    }
}
