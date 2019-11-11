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
    Observable.just("one", "two", "three", "four", "five")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(/* an Observer */);
}