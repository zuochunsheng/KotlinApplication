package com.example.edz.kotlinapplication.test

/**
 * anther: created by zuochunsheng on 2019/11/8 00 : 45
 * description :
 *
 */
fun main(args: Array<String>) {
    //使用方法
    // repeat(10) { println("index:$it") }

    repeat(10,{ println("index--:$it")})
    greaterThanZero(-1)
}

fun greaterThanZero(x:Int){
    require(x>0,{"数字必须大于0"})
    println(x)
}