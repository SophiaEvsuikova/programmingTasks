package com.example.padezh

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

// TODO переделать на спринговый тест с внедрением сервисного класса для склонения
internal class ChangingPadezhTests{
    private val result: ChangingPedezh = ChangingPedezh()

    private val word : String = "Елка"

    // TODO тест плохой, не проверяются формы падежей
    // нужно что-то типа assertEquals("Елка", result.get({индекс именительного падежа}))
    @Test
    fun spell_numberOfCases_Equals (){

        val numberOfCases = 6

        assertEquals(numberOfCases, result.spell(word).size)
    }
}