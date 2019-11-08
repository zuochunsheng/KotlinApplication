package com.example.edz.kotlinapplication.netchapter

import com.example.edz.kotlinapplication.deletest.Content
import java.util.*
import kotlin.reflect.KProperty

/**
 * @author:
 * @description:Kotlin运算符的一些实例
 */

class Complex(var real: Double,var imaginary: Double){
    //1.定义一个Complex类型+号运算符的方法
    operator fun plus(other: Complex): Complex{
        //实部real+虚步imaginary
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    //2.定一个Int类型的+号运算符的方法,返回Complex类型
    operator fun plus(other: Int):Complex{
        //实部real和虚步imaginary相加
        return Complex(real + other,imaginary)
    }

    //3.定义一个返回Int类型的
    operator fun plus(other: Any): Int{
        return real.toInt()
    }

    //4.定义一个取模的方法，实部的平方+虚步的平方，结果开平方
    operator fun invoke(): Double{
        return Math.hypot(real,imaginary)
    }


    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}


//书
class Book{
    //infix 自定义运算符的中缀表达式。本没有on，自定义一个，不需要类名.方法即可调用
    //传入任意类型，返回一个Boolean类型的参数
    infix fun on(any: Any): Boolean{
        return true
    }
}
//桌子
class Desk


class Cat(var name:String,var gender:String){

//使用operator关键字定义了两个函数
//需要注意的是，函数的名称一定是 component+数字()
//这时，如果调用了component1，那么得到的就是name

    operator fun component1() = name

    operator fun component2() =gender

}


class Delegate {

     operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
         return "${thisRef}, property '${property.name}' "
     }

     operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
         println("${thisRef} property '${property.name}' is setting value: '$value'")
     }
}

class DelegateProperties{
   var property : String by Delegate()
}

fun main(args: Array<String>) {
//    val c1 = Complex(3.0,4.0)  //3+4
//    val c2 = Complex(2.0,7.5)  //2+7.5
//    println(c1 + c2)  //5.0 + 11.5i
//    println(c1 + 20)  //23.0 + 4.0i
//    println(c1 + "Hello")  //3
//    //取模
//    println(c1()) //5.0
//
//
//    if(Book() on Desk()){
//        println("书在桌上")
//    }

//    val cat = Cat("Tom", "boy")
//    //cat.name
//    println(cat.component1())
//    println(cat.component2())


//    val ep = DelegateProperties()
//    println(ep.property) // DelegateProperties@433c675d, property 'property'
//    ep.property = "NewProperty" // DelegateProperties@433c675d property 'property' is setting value: 'NewProperty'


    //DelegateProperties的property属性的getter/setter是分别委托给上面这个Delegate类的getValue和setValue方法

}