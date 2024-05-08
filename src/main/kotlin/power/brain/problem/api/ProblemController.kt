package power.brain.problem.api

import io.swagger.v3.oas.annotations.Operation
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import power.brain.problem.entity.Problem
import power.brain.problem.repository.ProblemRepository


@RestController
@RequestMapping("/v1/api/problems")
class ProblemController (
    private val problemRepository: ProblemRepository
) {

    @Operation(summary = "Get Problem by Step")
    @GetMapping("/{problemId}")
    fun getProblem(@PathVariable problemId: Long): Problem? {
        return ResponseEntity(problemRepository.findById(problemId).orElseThrow { Exception("Problem not found") }
            , HttpStatus.OK).body
    }
}