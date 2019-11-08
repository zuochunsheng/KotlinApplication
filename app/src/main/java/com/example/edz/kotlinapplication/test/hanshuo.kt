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
    //greaterThanZero(3)

    //val cone = SingletonDemo.
    //val instance = LazyThreadSafeStaticInnerObject.instance
    //val instance = LazyThreadSafeStaticInnerObject.getInstance()

    //别名 暂不支持
    //typealias ab = friend
    //println(ab.name)

    for (i in 1..10) {
        if (i==3) continue  // i 为 3 时跳过当前循环，继续下一次循环
        println(i)
        if (i>5) break   // i 为 6 时 跳出循环
    }

}
class friend(var name:String){

}

fun greaterThanZero(x:Int){
    require(x>0,{"数字必须大于0"})
    println(x)
}