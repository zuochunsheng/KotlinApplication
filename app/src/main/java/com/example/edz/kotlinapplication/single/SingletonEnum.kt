package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 54
 * description :枚举类（线程安全，调用效率高，不能延时加载，可以天然的防止反射和反序列化调用）
 */
enum class SingletonEnum {
    //枚举元素本身就是单例
    INSTANCE;

    //添加自己需要的操作
    fun singletonOperation() {}
}
