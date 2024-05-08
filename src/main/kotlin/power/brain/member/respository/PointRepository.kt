package power.brain.member.respository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import power.brain.member.entity.Point

interface PointRepository : JpaRepository<Point, Long> {

//    @Query("SELECT SUM(point) FROM Point WHERE memberId = :memberId")
//    fun findSumPointByMemberId(memberId: Long): Long?

}