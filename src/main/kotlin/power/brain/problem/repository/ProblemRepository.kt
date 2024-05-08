package power.brain.problem.repository

import org.springframework.data.jpa.repository.JpaRepository
import power.brain.problem.entity.Problem

interface ProblemRepository: JpaRepository<Problem, Long>