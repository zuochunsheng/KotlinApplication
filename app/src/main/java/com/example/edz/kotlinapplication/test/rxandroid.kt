package com.example.edz.kotlinapplication.test

import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableSource
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
//      Flowable.just("Ios","Android").subscribe(::println)
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

//    Observable.create<String> { emitter ->
//        emitter.onNext("0")
//        emitter.onNext("1")
//        emitter.onNext("2")
//        emitter.onComplete()
//    }.subscribe ({ println("numIndex=$it") }, { t -> println(t) })
       //     .subscribe(::println, Throwable::printStackTrace)

//    Observable.create<Long> { emitter ->
//        while (!emitter.isDisposed) {
//            val time = System.currentTimeMillis()
//            emitter.onNext(time)
//            if (time % 2 != 0L) {
//                emitter.onError(IllegalStateException("Odd millisecond!"))
//                break
//            }
//        }
//    }.subscribe(Consumer<Long> { println(it) }, Consumer<Throwable> { it.printStackTrace() })

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
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(Schedulers.computation())
//                        .map { w -> w * w }
//            }
//            .blockingSubscribe (::println)


    actionFlatMapIterable()



}

fun actionFlatMapIterable() {
    val list = Arrays.asList(1, 2, 3, 4)

    Observable.fromIterable(list)
            .flatMap<String> { num ->
               Observable.just(num)
                       .map { v->v.toString() }
            }
            .subscribe { s -> println("flatMap accept=$s") }
//    flatMap accept=1
//    flatMap accept=2
//    flatMap accept=3
//    flatMap accept=4


    Observable.fromIterable(list)
            .flatMapIterable(object : Function<Int, Iterable<String>> {
                override fun apply(integer: Int): Iterable<String> {
                    return listOf("a" + integer, "b$integer", "c$integer")
                }
            }).subscribe { s -> println("accept=$s") }

//    accept=a1
//    accept=b1
//    accept=c1
//    accept=a2
//    accept=b2
//    accept=c2
//    accept=a3
//    accept=b3
//    accept=c3
//    accept=a4
//    accept=b4
//    accept=c4

}