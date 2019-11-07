package com.example.edz.kotlinapplication.deletest

/**
 * @author： zcs
 * @time：2019/10/31 on 17:35
 * @description：
 */
//请注意by realBuyer 表示XiaoHong的所有共有方法委托给一个指定的对象readlBuyer
class XiaoHong(val realBuyer: Buyer) : Buyer by realBuyer
//{
//
//    override fun buyCoach() {
//        println("Brother, please buy Coach for me.")
//        realBuyer.buyCoach()
//        println("Thanks Brother, I will give some money to you.")
//    }
//
//    override fun buyGucci() {
//        println("Brother, please buy Gucci for me.")
//        realBuyer.buyGucci()
//        println("Thanks Brother, I will give some money to you.")
//    }
//
//}



fun main(args:Array<String>){
    val xiaoHong = XiaoHong(XiaoMing())
    xiaoHong.buyCoach()
    xiaoHong.buyGucci()
}