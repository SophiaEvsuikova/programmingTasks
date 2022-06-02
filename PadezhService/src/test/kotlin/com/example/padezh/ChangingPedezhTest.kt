package com.example.padezh

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ChangingPadezhTests{
    private val result: ChangingPedezh = ChangingPedezh()

    private val word : String = "Елка"


    @Test
    fun spell_numberOfCases_Equals (){

        val numberOfCases = 6

        assertEquals(numberOfCases, result.spell(word).size)
    }
}