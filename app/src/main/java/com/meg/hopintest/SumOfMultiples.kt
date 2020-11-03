package com.meg.hopintest

data class SumOfMultiples(var n : Int) {

    fun sumOfMultiples() : Int {
        var sum = 0
        for (i in 1..n) {
            if(i%3 == 0 || i%5 ==0) {
                sum += i
            }
        }
        return sum
    }
}

fun main() {
    System.out.println("Sum of multiples of 3 or 5 :: ${SumOfMultiples(12).sumOfMultiples()}" )
}