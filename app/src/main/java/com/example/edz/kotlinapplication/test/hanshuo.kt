package com.example.edz.kotlinapplication.test

import com.example.edz.kotlinapplication.CoroutinesActivity
import com.example.edz.kotlinapplication.actual.Weak
import com.example.edz.kotlinapplication.single.SingleInstance

/**
 * anther: created by zuochunsheng on 2019/11/8 00 : 45
 * description :
 *
 */
fun main(args: Array<String>) {
    //使用方法
    // repeat(10) { println("index:$it") }

    repeat(10,{ println("index--:$it")})
    greaterThanZero(3)

    val cone = SingleInstance.cone

    //别名 暂不支持
   // typealias ab = SingleInstance
    //println(ab.cone)


}

fun greaterThanZero(x:Int){
    require(x>0,{"数字必须大于0"})
    println(x)
}