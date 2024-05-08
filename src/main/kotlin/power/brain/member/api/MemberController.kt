package power.brain.member.api

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import power.brain.member.dto.TimeDto
import power.brain.member.entity.Member
import power.brain.member.entity.Ranking
import power.brain.member.exception.FailedCreateMemberNickname
import power.brain.member.respository.MemberRepository
import power.brain.member.respository.RankingRepository
import power.brain.member.entity.Point
import power.brain.member.respository.PointRepository
import power.brain.problem.dto.ProblemDto
import power.brain.problem.repository.ProblemRepository
import java.util.*


@RestController
@RequestMapping("/v1/api")
class MemberController (
    private val memberRepository: MemberRepository,
    private val pointRepository: PointRepository,
    private val rankingRepository: RankingRepository,
    private val problemRepository: ProblemRepository
) {

    @Operation(summary = "Create Member")
    @PostMapping("/members")
    fun createMember(@RequestBody member: Member): Member? {
        val savedMember = memberRepository.save(member)

        runCatching {
            savedMember.memberId?.let { memberId ->
                // Save a Point with a default value of -1
                pointRepository.save(Point(memberId = memberId, point = 0, correct = -1))
            } ?: throw FailedCreateMemberNickname("MemberId is null")
        }.getOrElse {
            println("Exception caught: ${it.message}")
            throw FailedCreateMemberNickname("Failed to create member: ${it.message}")
        }

        return savedMember
    }

    @Operation(summary = "Select Answer")
    @PostMapping("/answer")
    fun addPoint(@RequestBody problemDto: ProblemDto): Long? {
        // Get the correct answer from the database.
        val correctAnswer = problemRepository.findById(problemDto.problemId).orElseThrow { Exception("Problem not found") }
        // Check if the selected answer is correct.
        if (correctAnswer.answerSummary == problemDto.selectedAnswer) {
            correctAnswer.point?.let {
                pointRepository.save(Point(
                    memberId = problemDto.memberId, point = it, correct = 1))
            }
        } else {
            correctAnswer.point = 0
        }

        return ResponseEntity(correctAnswer.problemId?.plus(1)
            , HttpStatus.CREATED).body
    }

//    @Operation(summary = "Create Ranking")
//    @PostMapping("/ranking/{memberId}")
//    fun createRanking(@PathVariable memberId: Long, @RequestBody time: TimeDto): ResponseEntity<Ranking> {
//        return memberRepository.findById(memberId)
//            .map { member ->
//                pointRepository.findSumPointByMemberId(memberId)?.let { sumPoint ->
//                    Ranking(
//                        member = member,
//                        memberPoint = sumPoint,
//                        rankingId = sumPoint + 1,
//                        minutes = time.minutes,
//                        seconds = time.seconds
//                    )
//                } ?: throw IllegalArgumentException("No points found for member")
//            }
//            .map { ranking -> rankingRepository.save(ranking) }
//            .map { savedRanking -> ResponseEntity(savedRanking, HttpStatus.CREATED) }
//            .orElseThrow { IllegalArgumentException("Member not found") }
//    }

//    @Operation(summary = "Update Time")
//    @PutMapping("/v1/api/member/{memberId}/time")
//    fun updateTime(@PathVariable memberId: Long, @RequestBody time: TimeDto): ResponseEntity<Unit>? {
//        return rankingRepository.findByMember(memberId)
//            ?.takeIf { it.rankingId != null }
//            ?.let { ranking ->
//                rankingRepository.updateTimeByRankingId(ranking.rankingId!!, time.minutes, time.seconds)
//            }
//            ?.let { ResponseEntity.ok().build() }
//            ?: ResponseEntity.status(HttpStatus.BAD_REQUEST).build()
//    }



    // TODO: Get the ranking list of members.
    @Operation(summary = "Get Ranking of Member")
    @GetMapping("/result/{memberId}")
    fun getRanking(@PathVariable memberId: Long): List<Ranking>? {

        //  Get the latest ranking list.
        val rankings = rankingRepository.findAll()
            .sortedWith(compareByDescending<Ranking> { it.memberPoint }
                .thenBy { it.minutes * 60 + it.seconds })

        return null
    }

//    "memberId": "",
//    "nickname": "",
//    "score": number,
//    "time": { "minutes": number, "seconds": number },
//    "answers": [{
//        "problemId": number;
//        "answer": string;
//        "isCorrect": boolean
//    }]


    // Get member nickname
    fun getMemberNickname(memberId: Long): Member {
        if (!isMemberValid(memberId)) {
            throw IllegalArgumentException("Invalid member ID")
        }
        return memberRepository.findById(memberId)
            .orElseThrow { NoSuchElementException("No member found with ID: $memberId") }
    }

    // Check member valid
    fun isMemberValid(memberId: Long): Boolean {
        return memberRepository.existsById(memberId)
    }

}