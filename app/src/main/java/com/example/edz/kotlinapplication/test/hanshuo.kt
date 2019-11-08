package com.example.edz.kotlinapplication.test


/**
 * anther: created by zuochunsheng on 2019/11/8 00 : 45
 * description :
 *
 */
fun main(args: Array<String>) {
    //使用方法
    // repeat(10) { println("index:$it") }

    // repeat(10,{ println("index--:$it")})


    //val cone = SingletonDemo.
    //val instance = LazyThreadSafeStaticInnerObject.instance
    //val instance = LazyThreadSafeStaticInnerObject.getInstance()

    //别名 暂不支持
    //typealias ab = Friend_add_adfd_fsf
    //println(ab.name)

    //foo();

//    var strCo: Runoob<String> = Runoob("a")
//    var anyCo: Runoob<Any> = Runoob<Any>("b")
//    anyCo = strCo
//
//    println(anyCo.foo())   // 输出 a

//    var strDCo = Runoob("a")
//    var anyDCo = Runoob<Any>("b")
//    strDCo = anyDCo

    //使用类
//    val a1: A<*> = A(12, "String", Apple("苹果"))
//    val a2: A<Any?> = A(12, "String", Apple("苹果"))   //和a1是一样的
//    val apple = a1.t3    //参数类型为Any
//    println(apple)
//    val apple2 = apple as Apple   //强转成Apple类
//    println("apple2.name=${apple2.name}")
//    //使用数组
//    val l:ArrayList<*> = arrayListOf("String",1,1.2f,Apple("苹果"))
//    for (item in l){
//        println(item)
//    }
//

    // greaterThanZero(3)
    //checkThanZero(-1)
}

class Friend_add_adfd_fsf(var name: String) {

}

fun greaterThanZero(x: Int) {
    require(x > 0, { "数字必须大于0" })
    println(x)
}
fun checkThanZero(x: Int) {
    check(x > 0, { "数字必须大于0" })
    println(x)
}

//fun foo() {
//    var ints = arrayOf(-1,0,1,2,3,4,5)
//    ints.forEach {
//        if (it == 0) return
//        print(it)
//    }
//}

fun foo() {
    var ints = arrayOf(-1,0,1,2,3,4,5)
    ints.forEach lit@ {
        if (it == 0) return@lit
        print(it)
    }
}//-112345

//fun foo() {
//    var ints = arrayOf(-1,0,1,2,3,4,5)
//    ints.forEach {
//        if (it == 0) return@forEach
//        print(it)
//    }
//}//-112345


//fun foo() {
//    var ints = arrayOf(-1,0,1,2,3,4,5)
//    ints.forEach(fun(value: Int) {
//        if (value == 0) return
//        print(value)
//    })
//}//-112345


fun <T> copyWhenGreater(list: List<T>, threshold: T): List<String>
        where T : CharSequence,
              T : Comparable<T> {
    return list.filter { it > threshold }.map { it.toString() }
}


// 定义一个支持协变的类
//class Runoob<out T>(val t: T) {
//    fun foo(): T {
//        return t
//    }
//}
// 定义一个支持逆变的类
class Runoob<in A>(a: A) {
    fun foo(a: A) {

    }
}

class A<T>(val t: T, val t2 : T, val t3 : T)
class Apple(var name : String)
