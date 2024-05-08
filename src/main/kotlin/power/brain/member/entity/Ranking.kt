package power.brain.member.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*


@Schema(description = "랭킹 스키마")
@Table(name = "RANKING_TB")
@Entity
data class Ranking(
    @Schema(description = "랭킹 순위")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val rankingId: Long? = null,
    @Schema(description = "포인트 총합")
    val memberPoint: Long,
    @Schema(description = "소요 분")
    val minutes: Long,
    @Schema(description = "소요 초")
    val seconds: Long,

    @Schema(description = "유저 ID")
    @OneToOne
    @JoinColumn(name = "memberId")
    val member: Member
)
