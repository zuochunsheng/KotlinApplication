package edz.example.com.kotlinapplication.test

import edz.example.com.kotlinapplication.netchapter.Person

/**
 * @author： zcs
 * @time：2019/11/5 on 17:11
 * @description：return 返回
 */
fun main(args: Array<String>) {

    var p = Person("abc", 12)

    //另一种用途 判断object为null的操作
    var letValue = p?.let {
        it.eat()//在函数体内使用it替代object对象去访问其公有的属性和方法
        println(it.age)
        it.sleep()
    }
   // let是以闭包的形式返回，返回函数体内最后一行的值，如果最后一行为空就返回一个Unit类型的默认值

//    let函数适用的场景
//
//    场景一: 最常用的场景就是使用let函数处理需要针对一个可null的对象统一做判空处理。
//    场景二: 然后就是需要去明确一个变量所处特定的作用域范围内可以使用



    var withValue = with(p) {
        eat()
        sleep()
    }
    println(withValue) //kotlin.Unit
    //with 适用于调用同一个类的多个方法时，可以省去类名重复，直接调用类的方法即可，经常用于Android中RecyclerView中onBinderViewHolder中，数据model的属性映射到UI上
    // 返回值为最后一行的值或者指定的return的表达式。


    // run函数实际上可以说是let和with两个函数的结合体，run函数只接收一个lambda函数为参数，以闭包形式返回，
    // 返回值为最后一行的值或者指定的return的表达式。
    var runValue = p?.run {
        eat()
        sleep()
    }
    println(runValue) //kotlin.Unit

    //apply
    //从结构上来看apply函数和run函数很像，唯一不同点就是它们各自返回的值不一样，
    // run函数是以闭包形式返回最后一行代码的值，而apply函数的返回的是传入对象的本身。
    var applyValue = p.apply {
        eat()
        sleep()
    }
    println(applyValue) //Person@76ed5528


    //适用于let函数的任何场景，also函数和let很像，只是唯一的不同点就是let函数最后的返回值是最后一行的返回值而also函数的返回值是返回当前的这个对象。一般可用于多个扩展函数链式调用
   var alsoValue = p?.also {
       it. eat()
       it.sleep()
    }


//    ifNotNull(p, "abc") {
//        p, value2 ->
//        //todo
//    }

  var pp =  checkNotNull(p,{"Activity parameter 'PHOTO_URL' is missing" })
//    requireNotNull(p,{"Activity parameter 'PHOTO_URL' is missing" })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    //lookForAlice(people) //Found!
   // 如果在lambda中使用return关键字，它会 从调用 lambda 的函数 中返回，并不只是 从 lambda 中返回，这样的return语句叫做 非局部返回，因为它从一个比包含return的代码块更大的代码块中返回了

    lookForAlice2(people) //Bob is not Alice

}

fun <T1, T2> ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
    if (value1 != null && value2 != null) {
        bothNotNull(value1, value2)
    }
}

//lambda
 fun lookForAlice(people: List<Person>) {
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }
    println("Alice is not found")
}
//要区分局部返回和非局部返回，要用到标签。想从一个lambda表达式处返回你可以标记它，
// 然后在return关键字后面引用这个标签。
fun lookForAlice1(people: List<Person>) {
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label
        }

    }
    println("Alice might be somewhere")
}

//匿名函数
//return从最近的使用fun关键字声明的函数返回。
fun lookForAlice2(people: List<Person>) {
    people.forEach(fun (personItem) {
        println(personItem.name)
        if (personItem.name == "Alice") return
        //else
        println("${personItem.name} is not Alice")
    })
}