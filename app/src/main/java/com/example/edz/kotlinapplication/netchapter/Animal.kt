package com.example.edz.kotlinapplication.netchapter

/**
 * @author： zcs
 * @time：2019/11/1 on 17:32
 * @description：
 */
class Animal @JvmOverloads constructor(name: String, type: Int = 0){

    fun talk(name: String, by: Int = 1) {

    }

    @JvmOverloads
    fun talkTo(name: String, by: Int = 1) {

    }

    @Throws(Exception::class)
    fun throwException() {
        throw Exception("hahaha")
    }
}