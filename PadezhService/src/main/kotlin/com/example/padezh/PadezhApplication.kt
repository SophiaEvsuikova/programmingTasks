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
// TODO вынести логику формирования всех форм слова в отдлеьный @Service класс и внедрять его в контроллер через @Autowired
@RestController
class ChangingPedezh{
    // TODO https://google.github.io/styleguide/javaguide.html 4.8.5.2 Class annotations форматирование кода аннотаций
    @RequestMapping(value =["/spell/{word}"], method = [(RequestMethod.GET)])

    @ResponseBody
    fun spell(@PathVariable ("word") word: String): List<String> {

        // https://morpher.ru/My/Token.aspx - для генерации токена
        val russianDeclensionResult: DeclensionResult = ClientBuilder()
            .useToken("a7baa109-f9db-4911-bf09-5d37cf015e12") // TODO токен выносится в application.properties, чтобы другие пользователи могли использовать свой, иначе придется всегда менять исходный код и перекомиплировать проект
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




