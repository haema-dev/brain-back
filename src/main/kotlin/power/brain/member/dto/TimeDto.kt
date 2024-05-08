package power.brain.member.dto

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "문제 풀이 시간 Dto")
data class TimeDto(
    @Schema(description = "분")
    val minutes: Long,
    @Schema(description = "초")
    val seconds: Long
)