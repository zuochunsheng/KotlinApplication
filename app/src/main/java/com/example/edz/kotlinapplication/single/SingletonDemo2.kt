package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 50
 * description :2.懒汉式(线程安全，调用效率不高，但是能延时加载)：
 */
class SingletonDemo2 private constructor() {
    companion object {
        private var instance: SingletonDemo2? = null
            get() {
                if (field == null) {
                    field = SingletonDemo2()
                }
                return field
            }
        @Synchronized
        fun get(): SingletonDemo2{
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }
}



//Java实现
//public class SingletonDemo2 {
//    private static SingletonDemo2 instance;
//    private SingletonDemo2(){}
//    public static synchronized SingletonDemo2 getInstance(){//使用同步锁
//        if(instance==null){
//            instance=new SingletonDemo2();
//        }
//        return instance;
//    }
//}