package edz.example.com.kotlinapplication.test

//import kotlinx.coroutines
import kotlinx.coroutines.*
import kotlinx.coroutines.GlobalScope.coroutineContext
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
//import kotlinx.coroutines.Unconfined
//import kotlinx.coroutines.CommonPool
import java.util.*

/**
 * @author： zcs
 * @time：2019/11/5 on 16:57
 * @description：
 */

//1 使用lauch来启动一个协程
//Thread.sleep会阻塞当前线程（线程就傻傻的在等待），而delay是暂停当前的协程，不会阻塞当前线程，
//这个线程可以去做其他事情。delay是一个suspending function，它只能运行在协程里面

//2 runBlocking函数会阻塞当前线程，一直等到协程运行完。
//3 延时一段时间来等待协程完成通常不是很高效，我们可以通过join来实现一旦协程完成就退出main函数。

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

//fun main(args: Array<String>) {
//
////    val job =  GlobalScope.launch { // launch a new coroutine in background and continue
////        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
////        println("World!") // print after delay
////    }
//
//    runBlocking<Unit> {
////        val job = GlobalScope.launch {
////            doWorld()
////        }
//
////    val jobs = List(100_000) { // launch a lot of coroutines and list their jobs
////        GlobalScope.launch {
////            delay(1000L)
////            print(".")
////        }
////    }
//
//        GlobalScope.launch {
//            repeat(1000) { i ->
//                println("I'm sleeping $i ...")
//                delay(500L)
//            }
//        }
//
//        println("Hello,")
//
//        //job.join()
//        //jobs.forEach({it.join()})
//
//        delay(1300)
//        println("runBlocking!")
//    }
//
//
////    GlobalScope.async  {
////        //workload 在挂起函数(挂起lambda)中被调用
////        workload(12)
////    }
//
////    GlobalScope. async {
////        //await()是挂起函数,该函数挂起一个协程,直到执行完成返回结果
////
////        //Continuation
////        // val result1 = computation.await()
////    }
//
//
//}

//4 注意：delay也是一个suspending function，
// 所以depay只能放在suspending function或者协程代码（lanuch）里面。


//当调用[suspend修饰的函数]时会发生协程挂起:
//该函数称为挂起函数,调用它们可能挂起协程(如果调用结果已经可用,协程库可决定不挂起)
//挂起函数能像普通函数获取参数和返回值,但只能在协程/挂起函数中被调用!
// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}


suspend fun doSomethingUsefulOne(): Int {
    delay(2000L) // pretend we are doing something useful here
    return 13
}

suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
}

//13
//async与launch类似，它也是启动一个协程，只不过lauch返回的是Job（没有返回值），而async返回的是Deferred（带返回值），你可以使用.await()来获取Deferred的值。Deferred是Job的子类，所以Deferred也可以被取消

//14 如果async带上了start = CoroutineStart.LAZY参数，协程不会立即执行，会等到调用await的时候才开始执行
//fun main(args: Array<String>) {
//    runBlocking {
//        val time = measureTimeMillis {
//            val one = GlobalScope.async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
//            val two = GlobalScope.async { doSomethingUsefulTwo() }
//            println("The answer is ${one.await() + two.await()}")
//        }
//        println("Completed in $time ms")
//    }
//}


// The result type of somethingUsefulOneAsync is Deferred<Int>
fun somethingUsefulOneAsync() = GlobalScope.async {
    doSomethingUsefulOne()
}

// The result type of somethingUsefulTwoAsync is Deferred<Int>
fun somethingUsefulTwoAsync() = GlobalScope.async {
    doSomethingUsefulTwo()
}
//15 上面两个方法xxxAsync并不是suspending functions，所以他们可以在任何地方调用。
//fun main(args: Array<String>) {
//    val time = measureTimeMillis {
//        // we can initiate async actions outside of a coroutine
//        val one = somethingUsefulOneAsync()
//        val two = somethingUsefulTwoAsync()
//        // but waiting for a result must involve either suspending or blocking.
//        // here we use `runBlocking { ... }` to block the main thread while waiting for the result
//        runBlocking {
//            println("The answer is ${one.await() + two.await()}")
//        }
//    }
//    println("Completed in $time ms")
//}

//fun main(args: Array<String>) = runBlocking<Unit> {
//    val jobs = arrayListOf<Job>()
////    jobs += GlobalScope.launch(Unconfined) { // not confined -- will work with main thread
////        println("      'Unconfined': I'm working in thread ${Thread.currentThread().name}")
////    }
//    jobs += GlobalScope.launch(coroutineContext) { // context of the parent, runBlocking coroutine
//        println("'coroutineContext': I'm working in thread ${Thread.currentThread().name}")
//    }
////    jobs += GlobalScope.launch(CommonPool) { // will get dispatched to ForkJoinPool.commonPool (or equivalent)
////        println("      'CommonPool': I'm working in thread ${Thread.currentThread().name}")
////    }
//    jobs += GlobalScope.launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
//        println("          'newSTC': I'm working in thread ${Thread.currentThread().name}")
//    }
//    jobs.forEach { it.join() }
//}


//19 一个是使用runBlocking指明一个特殊的Context，
// 另外一个是使用withContext来切换Context
//fun main(args: Array<String>) {
//    newSingleThreadContext("Ctx1").use { ctx1 ->
//        newSingleThreadContext("Ctx2").use { ctx2 ->
//            runBlocking(ctx1) {
//                log("Started in ctx1")
//                withContext(ctx2) {
//                    log("Working in ctx2")
//                }
//                log("Back to ctx1")
//            }
//        }
//    }
//}


//19. 通过Context来获取Job
//fun main(args: Array<String>) {
//    runBlocking<Unit>{
//        println("My job is ${coroutineContext[Job]}")
//    }
//}