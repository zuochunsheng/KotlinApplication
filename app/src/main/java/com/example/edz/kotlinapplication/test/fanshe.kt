package com.example.edz.kotlinapplication.test

/**
 * anther: created by zuochunsheng on 2019/11/9 16 : 44
 * description :
 *
 */

var prop = 1

class Phone(name: String) {
    var name: String = name
    fun sendMessage(msg: String) {
        println("${name} send a message :${msg}")
    }
}


fun main(args: Array<String>) {
    println(::prop.get())  //::prop 获取属性对象
    ::prop.set(2)

    val p_send = Phone("XiaoMing")

    p_send.sendMessage("Hello")
    p_send::sendMessage.call("Hello")//::sendMessage 获取函数实例
    Phone::sendMessage.call(p_send, "Hello")

    println(p_send.name)
    println(p_send::name.get())


    val kClass = p_send::class
    val members = kClass.members
    members.forEach { println("it.name=${it.name},t.returnType = ${it.returnType}") }


}