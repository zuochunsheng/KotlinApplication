package com.example.edz.kotlinapplication.single

/**
 * @author： zcs
 * @time：2019/10/29 on 18:54
 * @description：单例
 *  constructor 默认是pulic,但可以private 修改
 *  静态内部类实现模式（线程安全，调用效率高，可以延时加载）
 *  推荐写法
 */
class LazyThreadSafeStaticInnerObject private constructor(){
    companion object {
        fun getInstance() = Holder.instance
    }
    private object Holder {
        var instance = LazyThreadSafeStaticInnerObject()
    }


}