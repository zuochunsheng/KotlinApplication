package edz.example.com.kotlinapplication.chapter

import java.util.*

/**
 * @author： zcs
 * @time：2019/10/30 on 14:58
 * @description：
 */

open class Person(
        val name: String,
        var isMarried: Boolean
)

class Rectangle(val height: Int, val width: Int) {
//    val isSquare :Boolean
//        get(){
//            return height == width
//        }

    val isSquare: Boolean
        get() = height == width
}

fun createRandomRectangle() :Rectangle{
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
//    val person = Person("Bob", true)
//    println(person.name)
//    println(person.isMarried)
//
//    val rectangle = Rectangle(41, 43)
//    println(rectangle.isSquare)

    println(createRandomRectangle().isSquare)
}