package com.example.edz.kotlinapplication.test

import androidx.constraintlayout.solver.widgets.Rectangle

/**
 * @author： zcs
 * @time：2019/10/29 on 14:33
 * @description：
 */
fun main(args: Array<String>) {
    //val stringLength: Int = stringLengthFunc("Android")

    //stringMapper("Android", { input -> input.length })

    val items = listOf("apple", "banana", "kiwifruit")
//    for (item in items) {
//        println(item)
//    }

      //indices
//    for (index in items.indices) {
//        println("item at $index is ${items[index]}")
//    }

//    var index = 0
//    while (index < items.size) {
//        println("item at $index is ${items[index]}")
//        index++
//    }

//
//    for (x in 1..10 step 2) {// until
//        print(x)
//    }
//    println()
//    for (x in 9 downTo 0 step 3) {
//        print(x)
//    }

//    val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
//    fruits
//            .filter { it.startsWith("a") }
//            .sortedBy { it }
//            .map { it.toUpperCase() }
//            .forEach { println(it) }

    //LazyThreadSafeStaticInnerObject.getInstance()
}

//fun generateAnswerString(countThreshold: Int): String {
//    return if (count > countThreshold) {
//        "I have the answer."
//    } else {
//        "The answer eludes me."
//    }
//}
//
//fun generateAnswerString(countThreshold: Int): String = if (count > countThreshold) {
//    "I have the answer"
//} else {
//    "The answer eludes me"
//}
//返回类型 (String) -> Int
val stringLengthFunc: (String) -> Int = { input -> input.length }
val stringLengthFunc1 : (String) -> Int  = { it.length }

//高阶函数
fun stringMapper(str: String, mapper: (String) -> Int): Int {
    // Invoke function
    return mapper(str)
}

fun maxOf(a: Int, b: Int) = if (a > b) a else b


