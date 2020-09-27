package com.example.edz.kotlinapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bixin.bixingaigai.permission.PermissionHelper
import com.example.edz.kotlinapplication.actual.toast
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*


//kotlin 封装：
fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
    viewFinder(id) as V
}

//acitivity中扩展调用
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }


class MainActivity : AppCompatActivity() {


    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"

    //在activity中的使用姿势 ,buyong
    val mTextView by bindView<TextView>(R.id.tv_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 第二个参数 (PermissionHelper.OnPermissionListener) new MainActivity$onCreate$1(this),
        PermissionHelper.requestPermissions(
                this , listener(this),
                "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE"
        )
    }

    class listener constructor(val context: MainActivity) : PermissionHelper.OnPermissionListener {
        override fun onDenied() {//拒绝
            Toast.makeText(context, "需要存储权限", Toast.LENGTH_SHORT).show();
        }

        override fun onGranted() {
            context.initView();
        }

    }
    fun initView() {
        val mTextView = tv_text; // id ,shiyong
        val that = this;

        var androidId = "android"
        var uuid = "uuid"
        // text.text= "当前androidId："+androidId + ",\nuuid:"+uuid
        mTextView.text = """
            |androidId：$androidId
            |uuid: $uuid
        """.trimMargin()
    }

    fun skipNext(view: View) {

        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        // 为 Intent extra 定义键时，最好使用应用的软件包名称作为前缀。这样可以确保这些键是独一无二的，以便您的应用与其他应用进行交互。
        val intent = Intent(this, DisplayMessageActivity::class.java)
                .apply { putExtra(EXTRA_MESSAGE_MAIN, message) }
        startActivity(intent)

        //val inputId = message.trim()
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
        Log.e("tag","skipNextRetrofitKotlin");
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

//    1 main Thread :都会发射
//    2 main->连续new(>=1) ->main ：只有main会发射
//    3 连续new(>=1)（new结尾） ：最后一个new发射


    fun actionSwitchMap() {

        val list = listOf(1, 2,3,4,5,6)
        Observable.fromIterable(list)
                .switchMap(object : Function<Int, ObservableSource<String>> {
                    override fun apply(integer: Int): ObservableSource<String> {
                        if(integer == 2 ||integer == 3){
                            return  Observable.just("integer=" + integer).subscribeOn(Schedulers.newThread())
                        }
                        return Observable.just("integer=" + integer)
                    }
                }).subscribe(
                        { num -> Log.e("Operations", "accept=" + num + Thread.currentThread()?.name) },
                        { t -> {println(t); println("error")} },
                        {  println("complete")}
                )


    }
    // accept=integer=1main
    // accept=integer=3main
    // accept=integer=4main

    // accept=integer=2main
    // accept=integer=4RxNewThreadScheduler-3




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
            emitter.onComplete()
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
