package edz.example.com.kotlinapplication.chapter

import edz.example.com.kotlinapplication.chapter.Color.*
/**
 * @author： zcs
 * @time：2019/10/30 on 14:58
 * @description：
 */

enum class Color {
    RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET
}

//enum class Color(var r: Int, var g: Int, var b: Int) {
//    RED(255, 0, 0),
//    ORANGE(255, 165, 0),
//    YELLOW(255, 255, 0),
//    GREEN(0, 255, 0),
//    BLUE(0, 0, 255),
//    INDIGO(75, 0, 130),
//    VIOLET(238, 130, 238);
//
//    fun rgb() = (r * 256 + g) * 256 + b
//}

fun getMnemonic(color: Color) =
        when (color) {
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Gave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

//fun getWarmth(color: Color) =
//        when(color) {
//        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
//        Color.GREEN -> "neutral"
//        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
//}

// import
fun getWarmth(color: Color) =
        when(color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        BLUE, INDIGO, VIOLET -> "cold"
}
//集合类型：Set  无序不重复
fun mix(c1: Color, c2: Color) =
        when (setOf(c1, c2)) {
            setOf(RED, YELLOW) -> ORANGE
            setOf(YELLOW, BLUE) -> GREEN
            setOf(BLUE, VIOLET) -> INDIGO
            else -> throw Exception("Dirty color")
        }

fun main(args: Array<String>) {
   // println(Color.BLUE.rgb()) //255

//    println(getMnemonic(Color.BLUE))
//    println(getWarmth(Color.ORANGE))

    println(mix(BLUE, YELLOW))  //GREEN
}