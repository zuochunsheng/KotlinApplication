package com.example.edz.kotlinapplication.chapter


import java.io.BufferedReader
import java.io.StringReader

/**
 * @author： zcs
 * @time：2019/10/30 on 14:58
 * @description：
 */

//fun readNumber(reader: BufferedReader): Int? {
//    try {
//        val line = reader.readLine()
//        return Integer.parseInt(line)
//    }
//    catch (e: NumberFormatException) {
//        return null
//    }
//    finally {
//        reader.close()
//    }
//}
fun readNumber(reader: BufferedReader): Int? {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }
    return number
}

fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))  //239
}