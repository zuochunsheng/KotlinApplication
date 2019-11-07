package edz.example.com.kotlinapplication.netchapter

import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.rxkotlin.toObservable

/**
 * @author： zcs
 * @time：2019/11/7 on 16:21
 * @description：https://github.com/ReactiveX/RxKotlin
 */


fun main(args: Array<String>) {

    val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")

    list.toObservable() // extension function for Iterables
            .filter { it.length >= 5 }
            .subscribeBy(  // named arguments for lambda Subscribers
                    onNext = { println(it) },
                    onError = { it.printStackTrace() },
                    onComplete = { println("Done!") }
            )

//    list.toFlowable()
//            .filter({ it.length >= 5 })
//            .subscribeBy(
//                onError = { it.printStackTrace()},
//                onComplete = { println("Done!")},
//                onNext = {println(it) }
//            )

}
