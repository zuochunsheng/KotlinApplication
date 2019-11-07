package com.example.edz.kotlinapplication.deletest

import kotlin.reflect.KProperty

/**
 * @author： zcs
 * @time：2019/10/31 on 17:41
 * @description：
 */
class DelegatePropertiesDemo {
    var content: String by Content()

    override fun toString(): String {
        return "DelegatePropertiesDemo Class"
    }
}

class Content {
    operator fun getValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>): String {
        return "${delegatePropertiesDemo} property '${property.name}' = 'Balalala ... ' "
    }

    operator fun setValue(delegatePropertiesDemo: DelegatePropertiesDemo, property: KProperty<*>, value: String) {
        println("${delegatePropertiesDemo} property '${property.name}' is setting value: '$value'")
    }
}


fun main(args: Array<String>) {
    val delegatePropertiesDemo = DelegatePropertiesDemo()
    println(delegatePropertiesDemo.content)

    delegatePropertiesDemo.content = "abc"

//    DelegatePropertiesDemo的content属性的getter/setter是分别委托给下面这个Content类的getValue和setValue方法。注意getValue和setValue方法必须要使用operator修饰。


}