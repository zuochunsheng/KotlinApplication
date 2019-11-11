package com.example.edz.kotlinapplication.test

import kotlin.reflect.KTypeParameter

/**
 * @author： zcs
 * @time：2019/11/8 on 17:08
 * @description：反射
 * 原文链接：https://blog.csdn.net/ldxlz224/article/details/98376852
 */

open class BaseContainer<T>

class Container<T : Comparable<T>> : BaseContainer<Int> {

    var element: MutableList<T>

    constructor(element: MutableList<T>) : super() {
        this.element = element
    }

    fun sort(): Container<T> {
        element.sort()
        return this
    }

    override fun toString(): String {
        return "Container(element = $element)"
    }

}


//判断是否是奇数
fun isOdd(x: Int) = x % 2 != 0
fun main(args: Array<String>) {
    val container = Container(mutableListOf(1, 2, 3, 4, 5))
    // 获取Container的KClass对象引用
    val kClazz = container::class
    //val jClass = container.javaClass
    // KClass对象的typeParameters属性中存有类型参数的信息
    val typeParameters = kClazz.typeParameters
    //typeParameters 取数组的第一个
    val kTypeParameter: KTypeParameter = typeParameters[0]
    // kTypeParameter有下面等属性
    println(kTypeParameter.isReified) // false
    println(kTypeParameter.name) // T
    println(kTypeParameter.upperBounds) // [kotlin.Comparable<T>]
    println(kTypeParameter.variance) // INVARIANT

    val constructors = kClazz.constructors
    for (KFunction in constructors) {
        KFunction.parameters.forEach {
            val name = it.name
            val type = it.type
            println("name=$name") // name=elements
            println("type=$type") // type=kotlin.collections.MutableList<T>
            for (KTypeProjection in type.arguments) {
                println(KTypeProjection.type) // T
            }
        }
    }



//    val nums = listOf(1, 2, 3)
//    val filter = nums.filter(::isOdd)
//    println(filter)

}


//var a = 1
//
//fun main(args: Array<String>) {
//    println(::a.get())
//    ::a.set(2)
//    println(a)
//    表达式 ::a 等价于KProperty的一个属性，它可以允许我们通过get()函数获取值 ::a.get()
//    对于可变属性var a=1，返回类型为KMutableProperty的值，并且还有set方法::a.set(2)

//    val digitRegex = "\\d+".toRegex()
//
//    println(digitRegex.matches("1"))
//    println(digitRegex.matches("x"))
//    println(digitRegex.matches("4"))
//
//    val isDigit = digitRegex::matches
//    println(isDigit("3"))
//    println(isDigit("4"))
//    println(isDigit("x"))


//}