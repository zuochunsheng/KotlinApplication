package com.example.edz.kotlinapplication.test

/**
 * authr : edz
 * date  : 2018/3/14  上午11:53
 * describe ：
 */
class Mynumber (var k : Int) {
    private  fun Int.triple() = this * this * this

    fun addFactor (p :Int){
        k += p.triple()

    }

}