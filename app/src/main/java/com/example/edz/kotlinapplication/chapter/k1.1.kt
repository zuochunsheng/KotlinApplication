package com.example.edz.kotlinapplication.chapter

/**
 * @author： zcs
 * @time：2019/10/30 on 14:58
 * @description：
 */


//data class Person(val name: String, var age: Int? = null)




fun max(a: Int, b: Int): Int {
    return if (a > b) a else b
}


fun main(args: Array<String>) {
    //1.1
//    var persions = listOf(Person("Alice"), Person("Bob", 12))
//    val oldest = persions.maxBy { it.age ?: 0 }
//    println("The oldest is: $oldest")

    //2.1
//    val name = if (args.size > 0) args[0] else "Kotlin"
//    println("Hello, $name!")
//
//    if (args.size > 0) {
//        println("Hello, ${args[0]}!")
//    }
//
//    println("Hello, ${if (args.size > 0) args[0] else "someone"}!")


}