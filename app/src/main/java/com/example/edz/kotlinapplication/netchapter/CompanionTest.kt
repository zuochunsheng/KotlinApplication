package com.example.edz.kotlinapplication.netchapter


/**
 * @author： zcs
 * @time：2019/10/31 on 14:53
 * @description：companion object
 */
class Utils {
    private val MY_TAG = "DemoManager"

    object Object {
        const val MAX = 239
    }


    object StringUtils {//public static
        var c = Object.MAX;//public static

        val separator: String = """\"""
        fun isDigit(value: String): Boolean {//public
            for (c in value) {
                if (!c.isDigit()) {
                    return false
                }
            }

            return true
        }

        @JvmStatic
        fun c(): String {//public static
            return "c"
        }
    }

    //一个类只能有一个伴生对象。
    companion object ComObjUtil{//public static
        var b = Object.MAX;//private static
        fun isEmpty(value: String): Boolean {//public
            return value.isEmpty()
        }

        @JvmStatic
        fun b(): String {//public static
            return "b"
        }
    }
}


class ClassA{
    @JvmField
    val classAseparator: String = """\"""


}

fun main(args: Array<String>) {
//    val any = Any()
//    println(any)   //打印java.lang.Object@266474c2
//    println(any::class)  //打印class kotlin.Any
//    println(any::class.java)  //打印class java.lang.Object

    println("C:${Utils.StringUtils.separator}Users${Utils.StringUtils.separator}Denny") //打印c:\Users\Denny
    println(Utils.StringUtils.isDigit("12321231231"))  //打印true

    Utils.StringUtils.c()
    Utils.StringUtils.c

    println(Utils.isEmpty("xx"))
    Utils.b()
    Utils.b

     ClassA().classAseparator

}

