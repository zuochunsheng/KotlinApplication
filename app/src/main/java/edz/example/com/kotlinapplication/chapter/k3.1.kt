package edz.example.com.kotlinapplication.chapter

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment

val set = hashSetOf(1, 7, 53)
val list = arrayListOf(1, 7, 53)
val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

//fun <T> joinToString(
//        collection: Collection<T>,
//        separator: String,
//        prefix: String,
//        postfix: String
//): String {
//
//    val result = StringBuilder(prefix)
//
//    for ((index, element) in collection.withIndex()) {
//        println(index.toString()+"="+element.toString())
//        if (index > 0) result.append(separator)
//
//        result.append(element)
//         // ; 2
//    }
//
//    result.append(postfix)
//    return result.toString()
//}

fun <T> Collection<T>.joinToString(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(
        separator: String = ", ",
        prefix: String = "",
        postfix: String = ""
) = joinToString(separator, prefix, postfix)


fun String.lastChar(): Char = this.get(this.length - 1)

val String.lastChar: Char
    get() = get(length - 1)
var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

open class View {
    open fun click() = println("View clicked")
}

class Button: View() {
    override fun click() = println("Button clicked")
}
fun View.showOff() = println("I'm a view!")
fun Button.showOff() = println("I'm a button!")

// 扩展函数
inline fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
inline fun Fragment.toast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
}

fun main(args: Array<String>) {
//    println(set.javaClass) //java.util.HashSet
//    println(list.javaClass) //java.util.ArrayList
//    println(map.javaClass)  //java.util.HashMap

    //val strings = listOf("first", "second", "fourteenth")
    //println(strings.javaClass)  //java.util.Arrays$ArrayList
//    println(strings.last())
//    val numbers = setOf(1, 14, 2)
//    println(numbers.max())


   // val list = listOf(1, 2, 3)
//    println(joinToString(list, "; ", "(", ")"))


    //println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))

    //println("Kotlin".lastChar()) //n

    val view: View = Button()
    view.click()   //Button clicked
    view.showOff() //I'm a view!

    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))

    println("Kotlin".lastChar)

    val sb = StringBuilder("Kotlin")
    sb.lastChar = 'g'
    println(sb)  //Kotlig

    //var num = if (2>1) 2 else 1

}