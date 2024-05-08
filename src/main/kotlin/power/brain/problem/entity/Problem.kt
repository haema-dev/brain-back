package power.brain.problem.entity

import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*


@Table(name = "PROBLEM_TB")
@Entity
data class Problem(
    @Schema(description = "문제 ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val problemId: Long? = null,
    @Schema(description = "레벨 ID")
    val levelId: Long,
    @Schema(description = "문항 종류")
    val problemType: String,
    @Schema(description = "문항 텍스트")
    val problem: String,
    @Schema(description = "문항 이미지")
    val problemPicture: String,
    @Schema(description = "문항 정답")
    val answerSummary: String,
    @Schema(description = "문항 해설")
    var answerDetail: String,
    @Schema(description = "보기1")
    var choice1: String,
    @Schema(description = "보기2")
    var choice2: String,
    @Schema(description = "보기3")
    var choice3: String,
    @Schema(description = "보기4")
    var choice4: String,
    @Schema(description = "문항 점수")
    var point: Int
)