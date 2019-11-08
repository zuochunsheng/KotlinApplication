package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 52
 * description : 双重校验锁式（Double Check)
 * DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
 */
class SingletonDCLDemo private constructor(){

    companion object {
        val instance: SingletonDCLDemo by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
            SingletonDCLDemo()
        }
    }
}

//Java实现
//public class SingletonDCLDemo {
//    private volatile static SingletonDCLDemo instance;
//    private SingletonDCLDemo(){}
//    public static SingletonDCLDemo getInstance(){
//        if(instance==null){
//            synchronized (SingletonDCLDemo.class){
//                if(instance==null){
//                    instance=new SingletonDCLDemo();
//                }
//            }
//        }
//        return instance;
//    }
//}
