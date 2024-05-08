package power.brain.admin

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import power.brain.member.entity.Member
import power.brain.member.respository.MemberRepository
import power.brain.problem.entity.Problem
import power.brain.problem.repository.ProblemRepository

//TODO: 권한 추가해야함
@RestController
class AdminController (
    private val memberRepository: MemberRepository,
    private val problemRepository: ProblemRepository
    ) {

    @GetMapping("/v1/api/admin/members")
    fun getMembers(): MutableList<Member>? {
        return ResponseEntity(memberRepository.findAll(), HttpStatus.OK).body
    }

    @GetMapping("/v1/api/admin/problems")
    fun getProblems(): MutableList<Problem>? {
        return ResponseEntity(problemRepository.findAll(), HttpStatus.OK).body
    }

    @PostMapping("/v1/api/admin/problems")
    fun createProblem(@RequestBody problem: Problem): Problem? {
        return ResponseEntity(problemRepository.save(problem), HttpStatus.CREATED).body
    }
}