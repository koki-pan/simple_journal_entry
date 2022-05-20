package com.okeicalm.simpleJournalEntry.repository

import com.okeicalm.simpleJournalEntry.entity.Ball
import com.okeicalm.simpleJournalEntry.tables.Balls
import org.jooq.DSLContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class BallRepositoryImpl @Autowired constructor(private val dslContext: DSLContext) : BallRepository {
    override fun findAll(): List<Ball> {
        val result = dslContext.select()
            .from(Balls.BALLS)
            .fetch()
            .into(com.okeicalm.simpleJournalEntry.tables.pojos.Balls::class.java)

        return result.map { r -> Ball(r) }
    }

    override fun findById(id: Long): Ball? {
        val ballPOJO: com.okeicalm.simpleJournalEntry.tables.pojos.Balls? = dslContext
            .fetchOne(Balls.BALLS, Balls.BALLS.ID.eq(id))
            ?.into(com.okeicalm.simpleJournalEntry.tables.pojos.Balls::class.java)

        return ballPOJO?.let { Ball(it) }
    }

    override fun create(ball: Ball): Long {
        dslContext
            .newRecord(Balls.BALLS)
            .setName(ball.name)
            .setSize(ball.size)
            .setPrice(ball.price)
            .store()
        return dslContext.lastID().toLong()
    }

    override fun update(id: Long, ball: Ball): Long {
        dslContext
            .update(Balls.BALLS)
            .set(Balls.BALLS.NAME, ball.name)
            .set(Balls.BALLS.SIZE, ball.size)
            .set(Balls.BALLS.PRICE, ball.price)
            .where(Balls.BALLS.ID.eq(id))
            .execute()
        return id
    }

    override fun delete(id: Long): Long {
        dslContext
            .delete(Balls.BALLS)
            .where(Balls.BALLS.ID.eq(id))
            .execute()
        return id
    }
}
