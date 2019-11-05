package edz.example.com.kotlinapplication.netchapter

/**
 * @author： zcs
 * @time：2019/11/5 on 13:02
 * @description：
 */

fun main(args: Array<String>) {
    val list = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9) //和 45
    val mutableList = mutableListOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    //初始值 10
    //println(list.fold(10) { total, next -> total + next })
    //println(list.foldRight(10) { total, next -> total + next })

    //list.forEach { value -> if (value > 8) println(value) }
    //list.forEachIndexed { index, value -> if (value > 8) println("value of index $index is $value") }

    //println(list.none { it % 2 == 10 }) //true

    //println(list.reduce { total, next -> total + next })
    //println(list.reduceRight { total, next -> total + next })

    //println(list.slice(listOf(0, 4, 8)))
    //println(list.slice(0..2))
    //println(list.slice(listOf(0, 4, 80)))  //java.lang.ArrayIndexOutOfBoundsException: 80

   // println(list.flatMap { listOf(it, it + 1) })

   // println(list.groupBy { if (it % 2 == 0) "even" else "odd" })

   // println(list.map { it * 2 })
    //println(list.mapIndexed { index, it -> index * it })
    //println(list.mapNotNull { it * 2 })


    //println(list.partition { it % 2 == 0 })
    //println(list + listOf(10, 11))

    //println(list.zip(listOf(7, 8))) //[(0, 7), (1, 8)]
    println(listOf(Pair(5, 7), Pair(6, 8)).unzip()) //([5, 6], [7, 8])
}

//13、reduce：与fold一样，但没有初始值。通过一个函数从第一项到最后一项进行累计。
//    15、sumBy: 返回所有每一项通过函数转换之后的数据的总和。


//7、slice：过滤一个list 中指定 index 的元素

//1、flatMap：遍历所有的元素，为每一个创建一个集合，最后把所有集合放在一个集合中。

//    1、merge：把两个集合合并为一个新的，相同index的元素通过给定的函数进行合并生成新的元素作为新集合中的一个元素，返回新集合。新集合的大小由最小的那个集合大小决定 -->Kotlin 1.0 开始弃用
//    2、partition： 把一个给定集合的分割为两个，第一个集合是由原集合每一项元素匹配给定函数条件返回 true 的元素组成，第二集合为false
//    4、zip：返回由 pair 组成的 list,每个 pair 由 两个集合中相同index 的元素组成。该返回的 list 大小由最小的那个集合决定。
//    5、unzip：从包含 pair 的 List 中生成包含List的Pair

// stations_8.mer


//drop--返回去掉前n个元素后的列表；
//dropWhile--返回从第一项起，去掉满足条件的元素，直到不满足条件的一项为止；
//dropLastWhile--返回从最后一项起，去掉满足条件的元素，直到不满足条件的一项为止；
//
//filter--过滤掉所有不满足条件的元素；
//filterNot--过滤掉所有满足条件的元素；
//filterNotNull--过滤掉所有值为null的元素；
//
//slice--过滤掉非指定下标的元素，即保留下标对应的元素过滤List中指定下标的元素（比如这里只保留下标为1，3，4的元素），当过滤list中有元素值大于目标List大小时会出现异常；
//
//take--返回从第一个开始的n个元素；
//takeLast--返回从最后一个开始的n个元素；
//takeWhile--返回不满足条件的下标前面的所有元素的集合；



//flatMap--合并两个集合，可以在合并的时候对迭代元素值it多想要的操作；
//
//groupBy--将集合中的元素按照某个条件分组，返回Map；
//
//map--将集合中的元素通过某个方法转换后的结果存到一个集合中；
//mapIndexed--除了得到转换后的结果，还可以拿到index(下标)；
//mapNotNull--执行方法转换前过滤掉为null的元素；

//partition--根据判断条件是否成立，拆分成两个Pair；
//
//plus--合并两个List，可以用"+"替代；
//
//zip--两个集合按照下标组合成一个个的Pair塞到集合中返回；
//unzip--将包含多个Pair的List转换成含List的Pair；
//
//Pair对象的数据组成形式为(first, secord)，即Pair(1, 2).first可以取出数据1。