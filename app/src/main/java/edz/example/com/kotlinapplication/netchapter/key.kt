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

    val lazyValue: String by lazy { "Hello" }

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


    val firstTimestamp by lazy { System.currentTimeMillis() }
    println(firstTimestamp)
    Thread.sleep(500)
    println(firstTimestamp)
}