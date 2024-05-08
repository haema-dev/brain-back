package power.brain.level.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table


@Table(name = "LEVEL_TB")
@Entity
data class Level(
    @Schema(description = "레벨 ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val levelId: Long,
    @Schema(description = "레벨 이름")
    val levelName: String,
    @Schema(description = "레벨 최소점수")
    var minPoint: Int,
    @Schema(description = "레벨 최고점수")
    var maxPoint: Int
)
