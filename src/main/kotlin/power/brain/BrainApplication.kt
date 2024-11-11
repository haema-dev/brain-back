package power.brain

import io.swagger.v3.oas.annotations.Operation
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import power.brain.problem.entity.Problem

@SpringBootApplication
class BrainApplication

fun main(args: Array<String>) {
    // Application.kt 또는 아무 configuration 파일에서
    println("Current directory: ${System.getProperty("user.dir")}")
    runApplication<BrainApplication>(*args)
}
