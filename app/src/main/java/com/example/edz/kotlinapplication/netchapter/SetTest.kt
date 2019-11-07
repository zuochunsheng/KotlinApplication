package com.example.edz.kotlinapplication.netchapter

/**
 * @author： zcs
 * @time：2019/10/31 on 10:18
 * @description：
 *
 * A-B={10}，即把A中属于B的元素去掉
 *
 * 一般地，记A，B是两个集合，则所有属于A且不属于B的元素构成的集合，叫做集合A减集合B（或集合A与集合B之差），
 * 类似地，对于集合A、B，我们把集合x∣x∈A,且x∉B叫做A与B的差集
 */
fun main(args :  Array<String>) {

    //Set<类型>或setof(元素1，元素2.。。元素n)
    //大小固定，元素类型不可变
    val mailLine = setOf("鱼洞", "南坪", "碧津", "江北机场")
    val subLine = setOf("碧津", "双凤桥", "空港国际")
    val subLinew = setOf("碧津", "举人坝")
    //元素计数：count（），空否：isEmpty()
    //print(mailLine.count())
    //检查是否包含某个元素：contains，包含另一个Set:containsAll
    //println(mailLine.contains("南坪"))
    //println(mailLine.containsAll(subLine))
//转化为数组：toTypeArray()


    //集合之间的运算：intersect、subtract、union、minus(补集对象无需要是Set)
    val inter = mailLine.intersect(subLine)
    //println(inter)//-交集----->>[碧津]
    //println(mailLine.subtract(subLine))//-差集----->>[鱼洞, 南坪, 江北机场]
    //println(mailLine.union(subLine))//并集----》》[鱼洞, 南坪, 碧津, 江北机场, 双凤桥, 空港国际]
   // println(mailLine.minus(subLine))//补集--->>[鱼洞, 南坪, 江北机场]
//MutableSet <类型>或mutableSetof(元素1，元素2，，，，元素n)
    //大小可变，类型不变
    val mutableLine = mailLine.union(subLine).toMutableSet()
    //在末尾增加元素：add()方法，添加另一个集合：addAll方法
    //mutableLine.add("明佳路")
    //mutableLine.addAll(subLinew)
    //println(mutableLine)
    //移除元素：remove（） 移除一个集合removeAll
   // mutableLine.remove("明佳路")
   // mutableLine.removeAll(subLinew)
    //println(mutableLine)

    var stations_8 = arrayOf("南锣鼓巷", "什刹海", "鼓楼大街", "安德里北街",
            "安华桥", "北土城", "奥体公园", "奥林匹克公园", "森林公园南门", "什刹海", "鼓楼大街")

//    val stationNoRepeat = stations_8.distinct()
//    val smallStations = stations_8.sliceArray(2..3)
//    val smallStations1 =  stations_8.slice(2..3)
//
//    for (s in smallStations) {
//        print(s)
//    }
//






}