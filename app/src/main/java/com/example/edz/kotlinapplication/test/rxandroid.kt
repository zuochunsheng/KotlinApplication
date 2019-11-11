package com.example.edz.kotlinapplication.test

import io.reactivex.Observable


/**
 * @author： zcs
 * @time：2019/11/11 on 17:00
 * @description：
 */
fun main(args: Array<String>) {


    val numbers = Observable.just(1, 4.0, 3, 2.71, 2f, 7)
    val integers = numbers.ofType(Int::class.java)
    integers.subscribe { x: Int -> print(x.toString() + " ") }


}