package com.example.edz.kotlinapplication.test

import com.example.edz.kotlinapplication.netchapter.Person
import com.example.edz.kotlinapplication.netchapter.Student
import kotlin.collections.ArrayList
import kotlin.concurrent.thread

class heigh <out T> {
   //一百个函数 这一百个函数 只能获取 不能修改

    //只能获取
    fun getData() :T? = null
    //不能修改
   /* fun setData(d:T){}*/


}

fun main(args: Array<String>) {
    login("derry", "123456") {
        if(it){
          println("服务器验证 通过")
        }else{
            println("服务器验证 不通过")
        }
    }

    //java: // ? extends ,list集合 只能获取 ，不能修改
    // kt:// out 只能获取 ，不能修改
    var list: MutableList<out Person> = ArrayList<Student>()


    //java:// ? supper ,list集合 不能获取 ，能修改
    //kt:// in 不能获取 ，能修改
    var list2 :MutableList<in Student> = ArrayList<Person>();

    // 系统的使用线程
   var t : Thread = thread {
        println(1111)
    }

   var ttt = krun{
        println("在自定义线程里面")
        println("在自定义线程里面")
    }

    sum(20,30,30){ i1,i2,i3 ->
         i1+i2+i3
    }

    val name :String = "dsfdsf"
    var r =name.myLet{
        //it.length
        length
    }
}

//高阶函数 必须配置inline 内联 （内部会去优化）
public inline fun login(x: String, y: String, result: (Boolean) -> Unit): Unit {

    if (x == null || y == null) {
       return
    }
    loginEngine(x, y, result)
}

public inline fun loginEngine(x: String, y: String, result: (Boolean) -> Unit): Unit {
    if(x=="derry" && y=="123456"){
        result(true)
    }else{
        result(false)
    }

}

//自定义线程
fun krun(start:Boolean= true,
         threadName:String? = null,
         myRunAction:()->Unit):Thread{
     val thread = object:Thread(){
         override fun run() {
             super.run()
             myRunAction()
         }
     }
    threadName ?:"ThreadName"
    if(start){
        thread.start()
    }
    return thread
}


fun <R> sum(n1:Int,n2:Int,n3:Int,method:(Int,Int,Int)-> R) :R = method(n1,n2,n3)

//inline fun <T,R> T.myLet(){
//
//}

// T.myLet ：给 T  添加一个扩展函数
// method ：lam 标记位
// T被谁调用了 name,T == name == this
/*inline fun <T,R> T.myLet(method:(T)->R):R = method(this)*/


//T.() 给T添加匿名函数
inline fun <T,R> T.myLet(method:T.()->R):R = method(this)