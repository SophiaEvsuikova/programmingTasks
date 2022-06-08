package com.example.padezh

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.PathVariable
import ru.morpher.ws3.ClientBuilder
import ru.morpher.ws3.russian.DeclensionResult

@Service
class PadezhService {
    @Autowired
    lateinit var properties: AppProperties

    fun spell(@PathVariable("word") word: String): List<String> {

        // https://morpher.ru/My/Token.aspx - для генерации токена
        val russianDeclensionResult: DeclensionResult = ClientBuilder()
            .useToken(properties.token)
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