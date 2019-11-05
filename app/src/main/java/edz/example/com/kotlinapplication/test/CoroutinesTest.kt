package edz.example.com.kotlinapplication.test

import kotlinx.coroutines.*

/**
 * @author： zcs
 * @time：2019/11/5 on 16:57
 * @description：
 */

fun main(args: Array<String>) {
    GlobalScope.launch { // launch a new coroutine in background and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
    println("Hello,") // main thread continues while coroutine is delayed
    Thread.sleep(2000L) // block main thread for 2 seconds to keep JVM alive
}

