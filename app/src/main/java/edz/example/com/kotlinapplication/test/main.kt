package edz.example.com.kotlinapplication.test

/**
 * authr : edz
 * date  : 2018/3/14  上午11:18
 * describe ：
 * http://www.runoob.com/kotlin/kotlin-basic-syntax.html  kotlin 基础
 */


// 测试
fun main(args: Array<String>) {
    //vars(1,2,3,4,5)  // 输出12345

    // 3
    val sumLambda : (Int,Int)->Int ={x,y -> x+y}


    //4
    /* 字符串模板
     $ 表示一个变量名或者变量值

     $varName 表示变量值

     ${varName.fun()} 表示变量的方法返回值:*/
    var a = 1
    // 模板中的简单名称：
    val s1 = "a is $a"

    a = 2
    // 模板中的任意表达式：

    val s2 = "${s1.replace("is", "was")},but now is $a"


    //5 NULL检查机制
//    Kotlin的空安全设计对于声明可为空的参数，在使用时要进行空判断处理，有两种处理方式，
//    字段后加!!像Java一样抛出空异常，
//    另一种字段后加?可不做处理返回值为 null或配合?:做空判断处理

    //类型后面加?表示可为空
    var age: String? = "23"
    //抛出空指针异常
    val ages = age!!.toInt()

    //不做处理返回 null
    val ages1 = age?.toInt()
    //age为空返回-1
    val ages2 = age?.toInt() ?: -1


}


//6
fun getStringLength(obj :Any):Int?{
    if (obj is String) {
        // 做过类型判断以后，obj会被系统自动转换为String类型
        return obj.length
    }
    // 这里的obj仍然是Any类型的引用
    return null

}
//或者 在这里还有一种方法，与Java中instanceof不同，使用!is
/*fun getStringLength(obj: Any): Int? {
    if (obj !is String)
        return null
    // 在这个分支中, `obj` 的类型会被自动转换为 `String`
    return obj.length
}*/


//7
// 使用 step 指定步长
//for (i in 1..4 step 2) print(i) // 输出“13”

//for (i in 4 downTo 1 step 2) print(i) // 输出“42”


// 使用 until 函数排除结束元素
/*for (i in 1 until 10) {   // i in [1, 10) 排除了 10
    println(i)
}*/





//2
fun vars(vararg v: Int) {//可变参数 --》相当于数组
    for (vt in v) {
        print(vt)
    }
}

//1
/*fun sum(a: Int, b: Int): Int {   // Int 参数，返回值 Int
    return a + b
}*/
//简写
//fun sum(a: Int, b: Int) = a + b

public fun sum(a: Int, b: Int): Int = a + b   // public 方法则必须明确写出返回类型







/*
十进制：123
长整型以大写的 L 结尾：123L
16 进制以 0x 开头：0x0F
2 进制以 0b 开头：0b00001011
注意：8进制不支持

Kotlin 同时也支持传统符号表示的浮点数值：
Doubles 默认写法: 123.5, 123.5e10
Floats 使用 f 或者 F 后缀：123.5f
*/


/*
比较两个数字
Kotlin 中没有基础数据类型，只有封装的数字类型，你每定义的一个变量，
其实 Kotlin 帮你封装了一个对象，这样可以保证不会出现空指针。数字类型也一样，
所有在比较两个数字的时候，就有比较数据大小和比较两个对象是否相同的区别了。

在 Kotlin 中，三个等号 === 表示比较对象地址，两个 == 表示比较两个值大小。

*/
