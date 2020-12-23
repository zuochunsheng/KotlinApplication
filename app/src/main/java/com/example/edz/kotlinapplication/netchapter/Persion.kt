package com.example.edz.kotlinapplication.netchapter

import kotlin.reflect.KTypeParameter

/**
 * @author： zcs
 * @time：2019/10/31 on 16:10
 * @description：反射
 */

//: Any()
open class Person constructor(var name: String, isMarried: Boolean) {

    fun eat(){
        println("chifan")
    }
    fun sleep():String{
        //println("shuijiao")
        return "shuijiao"
    }
}



annotation class MyAutoware
class Student @MyAutoware public constructor(name: String,isMarried: Boolean) : Person(name, true) {
    var age: Int = 0

    //主构造函数不能包括任何代码。初始化代码可以放到以init关键字作为前缀的初始化块中
    init {
        println("Student(name = $name, isMarried = $isMarried) created")
    }

    //次构造函数的参数不能使用val或者var申明
    constructor(name: String, isMarried: Boolean, age: Int) : this(name, isMarried){
        this.age = age
    }
}

interface StudentService<T> {
    fun findStudent(name: String, isMarried: Boolean, age: Int): List<T>
}

abstract class BaseService<T> {
     abstract fun save(t: T): Int
}
class StudentServiceImpl : BaseService<Student>() , StudentService<Student> {
    override fun save(student:Student):Int {
        return 0
    }

   override fun  findStudent(name:String , isMarried: Boolean, age:Int):List<Student> {
        return listOf( Student("Jack",false, 20),
                       Student("Li", true,30)
                     )
    }
}

fun main(args: Array<String>) {
    val studentService = StudentServiceImpl()
    var num = studentService.save(Student("Tom",true,30))
    var list = studentService.findStudent("Jack",false,20)
    //反射API调用示例\
    //getClasses得到该类及其父类所有的public的内部类。
    //getDeclaredClasses得到该类所有的内部类，除去父类的。
    val studentServiceClass = studentService::class
    // KClass对象的typeParameters属性中存有类型参数的信息
    val typeParameters = studentServiceClass.typeParameters

    val annotations = studentServiceClass.annotations
    val constructors = studentServiceClass.constructors
    val members = studentServiceClass.members
    val qualifiedName = studentServiceClass.qualifiedName


    //typeParameters 取数组的第一个
    val kTypeParameter: KTypeParameter = typeParameters[0]
    // kTypeParameter有下面等属性
    println(kTypeParameter.isReified) // false
    println(kTypeParameter.name) // T
    println(kTypeParameter.upperBounds) // [kotlin.Comparable<T>]
    println(kTypeParameter.variance) // INVARIANT

    println(qualifiedName)

    for (KFunction in constructors) {
        KFunction.parameters.forEach {
            val name = it.name
            val type = it.type
            println("name=$name") // name=elements
            println("type=$type") // type=kotlin.collections.MutableList<T>
            for (KTypeProjection in type.arguments) {
                println(KTypeProjection.type) // T
            }
        }
    }

    for (k in annotations){

    }

//    Class<?>[] classes = studentServiceClass.getDeclaredClasses();
//    ClassLoader classLoader = studentServiceClass.getClassLoader();
//    Field[] fields = studentServiceClass.getDeclaredFields();
//    Method[] methods = studentServiceClass.getDeclaredMethods();
//    try {
//        methods[0].getName();
//        methods[0].invoke(studentService,"jack",20);
//    } catch (IllegalAccessException e) {
//        e.printStackTrace();
//    } catch (InvocationTargetException e) {
//        e.printStackTrace();
//    }

}
