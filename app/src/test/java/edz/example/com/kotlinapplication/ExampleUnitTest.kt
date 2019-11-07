package com.example.edz.kotlinapplication

import com.example.edz.kotlinapplication.javatest.Holeer
import com.example.edz.kotlinapplication.service.Service
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun suare(r: Double) {

        val c = Holeer.InnerHoleer.c
        Holeer.InnerHoleer.b()

        Holeer.INSTANCE.a()

        print("测试类")
    }

    @Test
    fun addition_githubService() {


        assertEquals(4, 2 + 2)
    }

}
