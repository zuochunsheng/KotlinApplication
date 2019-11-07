package com.example.edz.kotlinapplication.actual

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.example.edz.kotlinapplication.App
import java.io.*
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author： zcs
 * @time：2019/11/7 on 10:20
 * @description：
 */

//调用处
//private val zipCode: Long by DelegatesExt.preference(this, SettingsActivity.ZIP_CODE,
//        SettingsActivity.DEFAULT_ZIP)
//实现处
//object DelegatesExt {
//    fun <T> preference(context: Context, name: String, default: T) = Preference(context, name, default)
//}

class Preference<T>() {
    private var keyName: String? = null
    private var defaultValue: T? = null

    constructor(keyName: String,defaultValue: T) : this() {
        this.keyName = keyName
        this.defaultValue = defaultValue
    }

    private val prefs: SharedPreferences by lazy {
       App.instance.applicationContext.getSharedPreferences("default", Context.MODE_PRIVATE)
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T  {
        Log.e("info", "调用$this 的getValue()")
        return findSharedPreference(keyName!!, defaultValue!!)
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        Log.e("info", "调用$this 的setValue() value参数值为：$value")
        putSharedPreferences(keyName!!, value)
    }


    /**
     * 查找数据 返回一个具体的对象
     * 没有查找到value 就返回默认的序列化对象，然后经过反序列化返回
     */
    @Suppress("UNCHECKED_CAST")
    private fun  findSharedPreference(name: String, default: T): T = with(prefs) {
        val res: Any = when (default) {
            is Long -> getLong(name, default)
            is String -> getString(name, default)
            is Int -> getInt(name, default)
            is Boolean -> getBoolean(name, default)
            is Float -> getFloat(name, default)
            else -> deSerialization(getString(name, serialize(default)))
        }
        res as T
    }

    @SuppressLint("CommitPrefEdits")
    private fun  putSharedPreferences(name: String, value: T) = with(prefs.edit()) {
        when (value) {
            is Long -> putLong(name, value)
            is String -> putString(name, value)
            is Int -> putInt(name, value)
            is Boolean -> putBoolean(name, value)
            is Float -> putFloat(name, value)
            else -> putString(name, serialize(value))
        }.apply()
    }


    /**
     * 删除全部数据
     */
    fun clear() {
        Log.e("info", "调用$this clear()")
        prefs.edit().clear().commit()
    }

    /**
     * 根据key删除存储数据
     */
    fun remove(key: String) {
        Log.e("info", "调用$this remove()参数值为：$key")
        prefs.edit().remove(key).commit()
    }

    /**
     * 序列化对象
     */
    @Throws(Exception::class)
    private fun <T> serialize(obj: T): String {
        val byteArrayOutputStream = ByteArrayOutputStream()
        val objectOutputStream = ObjectOutputStream(
                byteArrayOutputStream)
        objectOutputStream.writeObject(obj)
        var serStr = byteArrayOutputStream.toString("ISO-8859-1")
        serStr = java.net.URLEncoder.encode(serStr, "UTF-8")
        objectOutputStream.close()
        byteArrayOutputStream.close()
        return serStr
    }

    /**
     * 反序列化对象
     */
    @Throws(Exception::class)
    private fun <T> deSerialization(str: String): T {
        val redStr = java.net.URLDecoder.decode(str, "UTF-8")
        val byteArrayInputStream = ByteArrayInputStream(
                redStr.toByteArray(charset("ISO-8859-1")))
        val objectInputStream = ObjectInputStream(
                byteArrayInputStream)
        val obj = objectInputStream.readObject() as T
        objectInputStream.close()
        byteArrayInputStream.close()
        return obj
    }


}

