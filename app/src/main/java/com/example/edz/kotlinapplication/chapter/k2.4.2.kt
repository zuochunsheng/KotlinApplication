package com.example.edz.kotlinapplication.chapter

import java.util.*

/**
 * @author： zcs
 * @time：2019/10/30 on 14:58
 * @description：
 */

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}

fun main(args: Array<String>) {
//    for (i in 100 downTo 1 step 2) {//[100-1] 含
//        print(fizzBuzz(i))
//    }

//    val binaryReps = TreeMap<Char, String>()
//    for (c in 'A'..'F') {
//        val binary = Integer.toBinaryString(c.toInt())
//        binaryReps[c] = binary
//    }
//
//    for ((letter, binary) in binaryReps) {
//        println("$letter = $binary")
//    }

    println(isLetter('q'))
    println(isNotDigit('x'))
}