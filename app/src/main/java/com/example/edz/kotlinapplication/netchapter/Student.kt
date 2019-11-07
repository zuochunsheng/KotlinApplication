package com.example.edz.kotlinapplication.netchapter

import com.example.edz.kotlinapplication.chapter.Person

/**
 * @author： zcs
 * @time：2019/10/31 on 16:10
 * @description：
 */

//: Any()
open class Person constructor(var name: String, var age: Int) {

    fun eat(){
        println("chifan")
    }
    fun sleep():String{
        //println("shuijiao")
        return "shuijiao"
    }
}



annotation class MyAutoware
class Student @MyAutoware public constructor(name: String, isMarried: Boolean) : Person(name, true) {
    var grade: Int = 1

    //主构造函数不能包括任何代码。初始化代码可以放到以init关键字作为前缀的初始化块中
    init {
        println("Student(name = $name, isMarried = $isMarried) created")
    }

    //次构造函数的参数不能使用val或者var申明
    constructor(name: String, isMarried: Boolean, grade: Int) : this(name, isMarried){
        this.grade = grade
    }
}