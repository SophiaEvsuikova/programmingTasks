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

@RestController
class ChangingPedezh{

    @RequestMapping(value =["/spell/{word}"], method = [(RequestMethod.GET)])

    @ResponseBody
    fun spell(@PathVariable ("word") word: String): List<String> {

        // https://morpher.ru/My/Token.aspx - для генерации токена
        val russianDeclensionResult: DeclensionResult = ClientBuilder()
            .useToken("a7baa109-f9db-4911-bf09-5d37cf015e12")
            .build()
            .russian()
            .declension(word)

        return listOf(
            russianDeclensionResult.nominative,
            russianDeclensionResult.genitive,
            russianDeclensionResult.dative,
            russianDeclensionResult.accusative,
            russianDeclensionResult.instrumental,
            russianDeclensionResult.prepositional
        )
    }
}




