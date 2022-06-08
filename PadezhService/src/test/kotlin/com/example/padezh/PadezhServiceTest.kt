package com.example.padezh

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class PadezhServiceTest {

    @Autowired
    lateinit var padezhService: PadezhService

    var word:String = "елка"
    val nominativeIndex = 0

    @Test
    fun spell() {
        val result = padezhService.spell(word)
        assertEquals(word, result[nominativeIndex])
    }
}