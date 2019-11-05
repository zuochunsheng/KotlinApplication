
@file:JvmName("Strings")
package edz.example.com.kotlinapplication.netchapter

import edz.example.com.kotlinapplication.javatest.Holeer

/**
 * @author： zcs
 * @time：2019/11/1 on 15:00
 * @description：
 */

class Box<T>(var value: T) {
    fun get(): T {
        return value
    }

    fun set(x: T) {
        this.value = x;
    }
}

fun <T> newBox(value: T) = Box(value)

fun <T : Comparable<T>> sort(list: List<T>) {}
//fun <T> cloneWhenGreater(list: List<T>, threshold: T): List<T>
//        where T : Comparable, Cloneable {
//    return list.filter(it > threshold).map(it.clone())
//}

interface Source<out T> {
    fun nextT(): T
}

//声明处协变
fun demo(str: Source<String>) {
    val obj: Source<Any> = str  //works

}

//fun <T> List<T>.sum2():T where T : Number , T: Appendable {}
fun isLargeThanFive(x: Int): Boolean = x > 5


fun String.firstChar() :Char{
    return this[0]
}

fun main(args: Array<String>) {
//    val box1:Box<String> = Box<String>("Denny")
//    val box2:Box<String> = Box("Denny")
//    val box3 = Box("Denny")
//
//    val box4 = Box(1)
//    val box5 = newBox(true)


    // box4.set("Jack") //编译错误。Type mismatch, Required: Int, Found String


    //java.util.Collections

    // 高阶函数 - 参数是 函数
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8)
//注意：我们使用::来引用一个函数。
    println(numbers.filter(::isLargeThanFive))  //打印[6, 7, 8]

    numbers.filter(
            fun(x: Int): Boolean {
                return x > 5
            }
    )
    numbers.filter(fun(x: Int) = x > 5)

    numbers.filter({ x: Int -> x > 5 })
    numbers.filter({ x -> x > 5 })

    numbers.filter({ it > 5 })
    //or 这样
    numbers.filter { it > 5 }


    //val max = { x: Int, y: Int -> if (x > y) x else y }
    //下面这句等同于上面这句代码。
    //val max: (Int, Int) -> Int = { x: Int, y: Int -> if (x > y) x else y }
    var arr = ArrayList<Any>();
    arr.add("hello")
    arr.add(12)
    println(arr)

    val listOf = arrayOf("Denny", "Deng")
   // Kotlin并没有可变类型，所以我们需要使用*+String集合 来表达String数组  来达到相应的目的
    println(Holeer.connect(*listOf))  //打印Denny,Deng
    println(connect(*listOf))  //打印Denny,Deng

//    val p = Person("name",12)
//    (p as java.lang.Object).wait()
//    val fooClass = p::class.java
//    val fooClass1 = p.javaClass

   // val runnable = Runnable { println("SAM") }

    Thread(Runnable { println("SAM") })

   println( Thread({println("SAM")}))
   println( Thread({println("SAM")}))


    //println(Holeer.`is`("a", "b"))  //打印false
}

fun connect(vararg strings: String): String {
    val sb = StringBuilder()
    for (string in strings) {
        sb.append(string).append(",")
    }
    return sb.toString()
}

// java 和 kotlin 相互调用