package power.brain.member.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.persistence.*


@Schema(description = "유저 스키마")
@Table(name = "MEMBER_TB")
@Entity
data class Member(
    @Schema(description = "유저 ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val memberId: Long? = null,
    @Schema(description = "유저 닉네임")
    val memberName: String,

    @OneToOne(mappedBy = "member")
    @JsonIgnore
    val ranking: Ranking?
)