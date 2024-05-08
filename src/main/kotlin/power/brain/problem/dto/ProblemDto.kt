package power.brain.problem.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "문제 풀기 Dto")
data class ProblemDto(
    @Schema(description = "유저 ID")
    val memberId: Long,
    @Schema(description = "문제 ID")
    val problemId: Long,
    @Schema(description = "선택한 정답")
    val selectedAnswer: String
)
