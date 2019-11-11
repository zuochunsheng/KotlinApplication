package com.example.edz.kotlinapplication.test

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author： zcs
 * @time：2019/11/11 on 10:19
 * @description：
 */

fun main(args: Array<String>) {

    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

//    list.toObservable() // extension function for Iterables
//            .filter { it.length >= 5 }
//            .subscribeBy(  // named arguments for lambda Subscribers
//                    onNext = { println(it) },
//                    onError = { it.printStackTrace() },
//                    onComplete = { println("Done!") }
//            )

//    list.toFlowable()
//            .filter({ it.length >= 5 })
//            .subscribeBy(
//                onError = { it.printStackTrace()},
//                onComplete = { println("Done!")},
//                onNext = {println(it) }
//            )


}