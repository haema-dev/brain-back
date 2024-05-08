package power.brain.member.exception

data class FailedCreateMemberNickname(val nickname: String) : RuntimeException("Failed to insert member with nickname: $nickname")
