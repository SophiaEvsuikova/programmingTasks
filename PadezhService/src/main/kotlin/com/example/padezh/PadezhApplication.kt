package com.example.padezh

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*
import ru.morpher.ws3.ClientBuilder
import ru.morpher.ws3.russian.DeclensionResult

@SpringBootApplication
class PadezhApplication

fun main() {
    runApplication<PadezhApplication>()
}
