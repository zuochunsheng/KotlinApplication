package com.example.edz.kotlinapplication.test

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*


/**
 * @author： zcs
 * @time：2019/11/11 on 17:00
 * @description：
 */
fun main(args: Array<String>) {
//    Flowable.just("Hello world").subscribe(::println)
//
//    Flowable.range(1, 10)
//            .observeOn(Schedulers.computation())
//            .map { v -> v * v }
//            .filter{v -> v % 3 == 0}
//            .blockingSubscribe(::println)
//
//
//    Observable.just<Number>(1, 4.0, 3, 2.71, 2f, 7)
//              .ofType(Int::class.java)
//              .subscribe { x: Int -> println(x.toString() + " ") }


//    Observable.create<Any> { emitter ->
//        while (!emitter.isDisposed) {
//            val time = System.currentTimeMillis()
//            emitter.onNext(time)
//            if (time % 2 != 0L) {
//                emitter.onError(IllegalStateException("Odd millisecond!"))
//                break
//            }
//        }
//    }
//            .subscribe(Consumer<Any> { println(it) }, Consumer<Throwable> { it.printStackTrace() })

//    Flowable.fromCallable {
//        Thread.sleep(1000) //  imitate expensive computation
//        "Done"
//    }
//            .subscribeOn(Schedulers.io())
//            .observeOn(Schedulers.single())
//            .subscribe({ println(it) }, { it.printStackTrace() })
//
//    Thread.sleep(2000) // <--- wait for the flow to finish


//    Flowable.range(1, 10)
//            .flatMap { v ->
//                Flowable.just(v)
//                        .subscribeOn(Schedulers.computation())
//                        .map { w -> w * w }
//            }
//            .blockingSubscribe (::println)


    actionFlatMapIterable()


}

fun actionFlatMapIterable() {
    val list = Arrays.asList(1, 2, 3)

    Observable.fromIterable(list)
            .flatMapIterable(object : Function<Int, Iterable<String>> {
                @Throws(Exception::class)
                override fun apply(integer: Int): Iterable<String> {
                    return Arrays.asList("a" + integer!!, "b$integer", "c$integer")
                }
            }).subscribe { s -> println("accept=$s") }
}