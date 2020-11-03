package com.meg.hopintest


import org.junit.Assert.*
import org.junit.Test

class SumOfMultiplesTest {

    @Test
    fun sumOfMultiples() {
        val n = 10
        val sum = 33
        assertEquals(33,sum)
    }

    @Test
    fun sumOfMultiplesTest() {
        val sum = SumOfMultiples(10).sumOfMultiples()
        assertEquals(33, sum )
    }
}