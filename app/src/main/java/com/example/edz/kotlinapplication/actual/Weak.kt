package com.example.edz.kotlinapplication.actual

import java.lang.ref.WeakReference
import kotlin.reflect.KProperty

/**
 * @author： zcs
 * @time：2019/11/1 on 12:13
 * @description：弱引用封装类 -kotlin
 */
class Weak<T : Any>(initializer: () -> T?) {
    var weakReference = WeakReference<T?>(initializer())

    constructor() : this({
        null
    })

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T? {
        return weakReference.get()
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T?) {
        weakReference = WeakReference(value)
    }

}

