package power.brain.member.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*


@Table(name = "POINT_HISTORY_TB")
@Entity
data class Point (
    @Schema(description = "문제 ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var pointId: Long? = null,
    @Schema(description = "유저 ID")
    var memberId: Long,
    @Schema(description = "맞춘 문항 점수")
    var point: Int,
    @Schema(description = "맞춘 문항 여부")
    var correct: Int
)