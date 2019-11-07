package com.example.edz.kotlinapplication.single

/**
 * anther: created by zuochunsheng on 2019/11/7 22 : 52
 * description : DCL也就是双重锁判断机制（由于JVM底层模型原因，偶尔会出问题，不建议使用）
 */
//object SingletonDCLDemo {
//
//    @Volatile
//    private var SingletonDCLDemo: SingletonDCLDemo? = null
//
//    fun newInstance(): SingletonDCLDemo? {
//        if (SingletonDCLDemo == null) {
//            synchronized(SingletonDCLDemo!!::class.java) {
//                if (SingletonDCLDemo == null) {
//                    SingletonDCLDemo = SingletonDCLDemo()
//                }
//            }
//        }
//        return SingletonDCLDemo
//    }
//}
