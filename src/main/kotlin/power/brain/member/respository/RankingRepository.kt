package power.brain.member.respository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import power.brain.member.entity.Ranking

interface RankingRepository: JpaRepository<Ranking, Long> {

//    fun findByMember(memberId: Long): Ranking?

//    @Query("UPDATE Ranking SET minutes = :minutes, seconds = :seconds WHERE rankingId = :rankingId")
//    fun updateTimeByRankingId(rankingId: Long, minutes: Long, seconds: Long)
}