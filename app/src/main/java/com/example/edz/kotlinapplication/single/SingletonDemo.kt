package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 43
 * description :
 *1、饿汉式(线程安全，调用效率高，但是不能延时加载)：
 * 不推荐这种实现方式
 */

object SingletonDemo {
    var cone = "1vc"

    fun chi(){
        println("SingleInstance chi")
    }

}

//Java实现
//public class SingletonDemo {
//    private static SingletonDemo instance=new SingletonDemo();
//    private SingletonDemo(){
//
//    }
//    public static SingletonDemo getInstance(){
//        return instance;
//    }
//}