package com.example.edz.kotlinapplication

import com.example.edz.kotlinapplication.R
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.edz.kotlinapplication.actual.toast
import com.example.edz.kotlinapplication.chapter.list
import com.google.gson.Gson
import com.example.edz.kotlinapplication.service.HttpResultObserver
import com.example.edz.kotlinapplication.service.User
import com.example.edz.kotlinapplication.service.api
import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import java.util.*

//kotlin 封装：
fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
    viewFinder(id) as V
}

//acitivity中扩展调用
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }


class MainActivity : AppCompatActivity() {


    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"

    //在activity中的使用姿势
    val mTextView by bindView<TextView>(R.id.tv_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun skipNext(view: View) {

        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        // 为 Intent extra 定义键时，最好使用应用的软件包名称作为前缀。这样可以确保这些键是独一无二的，以便您的应用与其他应用进行交互。
        val intent = Intent(this, DisplayMessageActivity::class.java)
                .apply { putExtra(EXTRA_MESSAGE_MAIN, message) }
        startActivity(intent)
    }

    fun skipNextCoroutine(view: View) {
        val intent = Intent(this, CoroutinesActivity::class.java)
        startActivity(intent)
    }

    fun initByUser(view: View) {

        mTextView.text = "执行到我时，才会进行控件初始化"
        mTextView.textSize = 23f
        mTextView.gravity = Gravity.CENTER

        with(mTextView) {
            text = "执行到我时，才会进行控件初始化"
            textSize = 23f
            gravity = Gravity.CENTER
        }

    }

    fun skipNextRetrofitKotlin(view: View) {
//        val intent = Intent(this, RetrofitRxKotlinActivity::class.java)
//        startActivity(intent)
        toast("skipNextRetrofitKotlin")
        //actionFlatMap();

        //actionSwitchMap0();
        actionSwitchMap();
    }


    fun actionSwitchMap0() {
        val list = listOf(1, 2, 3, 4)
        Observable.fromIterable(list)
                .switchMap(object : Function<Int, ObservableSource<String>> {
                    override fun apply(integer: Int): ObservableSource<String> {
                        return Observable.just("integer=" + integer)
                    }
                }).subscribe { s -> Log.e("Operations", "accept=" + s + Looper.myLooper()?.thread!!.name) }
    }

    fun actionSwitchMap() {

        val list = listOf(1, 2, 3, 4)
        Observable.fromIterable(list)
                .switchMap(object : Function<Int, ObservableSource<String>> {
                    override fun apply(integer: Int): ObservableSource<String> {
                        if(integer == 2){
                            return  Observable.just("integer=" + integer).subscribeOn(Schedulers.newThread())
                        }
                        return Observable.just("integer=" + integer)
                    }
                }).subscribe({ num -> Log.e("Operations", "accept=" + num + Thread.currentThread()?.name) }, { t -> println(t) })


    }

    fun actionFlatMap() {

        var list = listOf(1, 2, 3);

        Observable.fromIterable(list)
                .flatMap<String> { integer ->
                    log("开始执行，第" + integer + "圆球的任务" + getThreadName())
                    getObservable(integer)
                }.subscribe { s -> log("已完成" + s + getThreadName()) }



    }

    fun getObservable(integer: Int): Observable<String> {
        return Observable.create<String> { emitter ->
            emitter.onNext("第" + integer + "圆球的第1个棱形任务");
            if (integer != 1) {
                // 第2和第3个圆球的第二个任务延时。
                Thread.sleep(5 * 1000);
            }
            emitter.onNext("第" + integer + "圆球的第2个棱形任务");
            emitter.onComplete();
        }.subscribeOn(Schedulers.newThread())
    }


    // 返回当前的线程名
    fun getThreadName(): String {
        return "  |  ThreadName= ${Thread.currentThread()?.name}"
    }

    fun log(log: String) {
        Log.e("FlatMap", log)
    }


}
