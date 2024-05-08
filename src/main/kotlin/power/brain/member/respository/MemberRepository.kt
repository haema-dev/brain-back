package power.brain.member.respository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import power.brain.member.entity.Member

@Repository
interface MemberRepository : JpaRepository<Member, Long>