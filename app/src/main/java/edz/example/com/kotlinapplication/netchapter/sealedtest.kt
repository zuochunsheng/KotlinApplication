package edz.example.com.kotlinapplication.netchapter

/**
 * @author： zcs
 * @time：2019/11/1 on 17:48
 * @description：
 */

/**
 * 密封类
 * 1.密封类用sealed关键词表示
 * 2.密封类的子类只能定义在密封类的内部或同一个文件中，因为其构造方法为私有的
 * 3.密封类相比于普通的open类，可以不被此文件外被继承，有效保护代码
 * 4.与枚举的区别：密封类适用于子类可数的情况，枚举适用于实例可数的情况
 *
 * 1一个密封类自身是抽象的，它不能直接实例化但可以有抽象成员。

   2不允许有非private的构造方法。
 */
sealed class PlayerCmd { //演奏控制类（密封类）
    val playerName: String = "Player"

//    abstract class playabc(){
//        fun showUrlplayabc() {
//            println("showUrlplayabc")
//        }
//    }
//    private constructor(playerName:String){
//
//    }
    //演奏类
    class Player(val url: String, val position: Long = 0): PlayerCmd() {
        fun showUrl() {
            println("$url, $position")
        }
    }

    class Seek(val position: Long): PlayerCmd() //快进

    object Pause: PlayerCmd() //暂停（无需进行重载的类适合用单例object）
}

//（密封类的子类也可以定义在密封类的外部，但要在同一个文件中）
object Resume: PlayerCmd() //继续

object Stop: PlayerCmd() //停止

enum class PlayerState { //枚举适合表现简单的状态
    IDLE, PAUSE, PLAYING, STOP
}

fun main(args: Array<String>) {


    PlayerCmd.Player("苍茫的天涯").showUrl()
    println(Resume.playerName)
}