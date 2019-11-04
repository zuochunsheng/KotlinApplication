package edz.example.com.kotlinapplication

import android.app.Application

/**
 * @author： zcs
 * @time：2019/11/1 on 11:00
 * @description：
 */
class App : Application() {
    companion object {
        private var instance: Application? = null
        fun  instance() = instance!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}