package com.example.padezh

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class PadezhController {

    @Autowired
    lateinit var padezhService: PadezhService

    @RequestMapping(value =["/spell/{word}"], method = [(RequestMethod.GET)])
    fun spell(@PathVariable word: String): List<String> {

        return padezhService.spell(word)
    }
}
