package com.example.edz.kotlinapplication

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * @author： zcs
 * @time：2019/11/1 on 11:00
 * @description：
 */
class App : Application() {
    companion object {
        lateinit var instance: Application
            private set

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

    }
}