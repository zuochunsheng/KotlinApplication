package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 50
 * description :2.懒汉式(线程安全，调用效率不高，但是能延时加载)：
 */
object SingletonDemo2 {
    //类初始化时，不初始化这个对象(延时加载，真正用的时候再创建)
    private var instance: SingletonDemo2? = null

    //方法同步，调用效率低
    @Synchronized
    fun getInstance(): SingletonDemo2 {
        if (instance == null) {
            instance = SingletonDemo2()
        }
        return instance
    }
}//构造器私有化
