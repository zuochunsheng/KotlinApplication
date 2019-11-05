package edz.example.com.kotlinapplication.netchapter

import kotlin.properties.Delegates


/**
 * @author： zcs
 * @time：2019/11/1 on 11:07
 * @description：
 */

class User {
//    var name: String by Delegates.observable("<no name>") {
//        prop, old, new ->
//        println("${prop.name}   $old -> $new")
//    }
    //var friend: String by Delegates.notNull()

    private lateinit var address: String

//    1、包含一个 lambda，当第一次执行 getValue 时该 lambda 会被调用，所以该属性可以被延迟初始化。之后的调用都只会返回同一个值。
//    2、lazy 操作符是线程安全的。
//    3、如果不担心多线程问题或想提高更多的性能，可以使用 lazy(LazyThreadSafeMode.NONE) { ... }
//    4、一般 lazy 委托的代码块可以阻止在多个不同的线程中创建多个对象。
    val lazyValue: String by lazy(LazyThreadSafetyMode.NONE) { "Hello" }

    var max: Int by Delegates.vetoable(1) {
        property, oldValue, newValue ->
        newValue > oldValue
    }

    var name: String by Delegates.observable("<no name>", {
         prop, old, new ->
        println("${prop.name}   $old -> $new")
    })


}


class UserX(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int     by map
}



fun main(args: Array<String>) {
//    val user = User()
//    user.name = "first"  //name <no name> -> first
//    user.name = "second"  //name   first -> second

//    val user = UserX(mapOf(
//            "name" to "John Doe",
//            "age"  to 23
//    ))
//    println("name = ${user.name}, age = ${user.age}")

    //lambda 表达式 最后一行是返回结果 ，不用return
    val firstTimestamp by lazy { System.currentTimeMillis() }
    println(firstTimestamp)
    Thread.sleep(500)
    println(firstTimestamp)
}