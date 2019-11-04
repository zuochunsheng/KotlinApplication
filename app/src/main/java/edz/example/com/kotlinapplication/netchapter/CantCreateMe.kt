package edz.example.com.kotlinapplication.netchapter

/**
 * @author： zcs
 * @time：2019/10/31 on 16:09
 * @description：
 */

class CantCreateMe private constructor(){

    var name: String = ""

    constructor(name: String) : this() {
        this.name = name
    }
}

class Point constructor(var x:Int ,var y:Int){

    operator fun plus(p: Point) {
        x += p.x
        y += p.y
    }
}

fun main(args: Array<String>) {
    val p1 = Point(8,10)
    val p2 = Point(2,3)

    val psum1 = p1 + p2
    //val psum2 =p1.plus(p2)

    println("Point p1(x = ${p1.x}, y = ${p1.y})")
    println("Point p2(x = ${p2.x}, y = ${p2.y})")
    println(psum1)
    //println(psum2)

}