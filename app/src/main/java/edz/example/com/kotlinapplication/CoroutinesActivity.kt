package edz.example.com.kotlinapplication

import android.os.Build.VERSION_CODES.P
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import edz.example.com.kotlinapplication.service.HttpResultObserver
import edz.example.com.kotlinapplication.service.User
import edz.example.com.kotlinapplication.service.api
import edz.example.com.kotlinapplication.service.api.getStarGazers
import kotlinx.coroutines.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

//[Android中使用Kotlin协程(Coroutines)和Retrofit进行网络请求(三)之异常处理与封装](https://blog.csdn.net/weixin_44407870/article/details/87642687)
//[Retrofit搭配协程，真香耶！](https://www.jianshu.com/p/66121f923576)
//[20个Android必备第三方框架](https://www.jianshu.com/p/458ebd5d3668)
class CoroutinesActivity : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        textView = findViewById(R.id.tv)

        textView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
               // ui()
                requestDataToUI()
            }
        })

    }

//
//    fun ui() {
//
//        // ok
////        Service.gitHubService().getStarGazers()
////                .subscribeOn(Schedulers.io())
////                .observeOn(AndroidSchedulers.mainThread())
////                .subscribe(Consumer {
////                    it.map() {
////                        var gson = Gson()
////                        Log.e("user", gson.toJson(it))
////                    }
////                })
//
//        var disposable = getStarGazers(object : HttpResultObserver<List<User>>() {
//            protected override fun onResult(resultBean: List<User>) {
//                var gson = Gson()
//                Log.e("user disposable", gson.toJson(resultBean))
//
//            }
//
//            protected override fun onFailure(code: String, error: String) {
//                //LogUtil.e("onFailure vcode:"+mView.getSmsParament().getVcode());
//
//            }
//
//        })
//
//
//    }


//    GlobalScope.launch()：是个顶层的开启协程的方法，可以看官网都有
//    Dispatchers.Main：是个调度器，是个枚举，里面有几个调度器类型，Main这个就认为把网络请求到的数据切换到主线程就可以啦
    fun requestDataToUI() {
        GlobalScope.launch(Dispatchers.Main) {
            try {

                //从这里开始请求网络
                getXXData() //成功回调
            } catch (t: Throwable) {
                //失败回调
                //to do something
            }
        }
    }

//    suspend：吊起了，才能有更多的主动性的操作。
//    withcontext()：协程内，切换到指定的上下文
//    Dispatchers.IO：跟上面那个Main调度器一个妈生的
    suspend fun getXXData() = withContext(Dispatchers.IO) {
        requestData()
    }

//    suspendCancellableCoroutine{ continuation ->}：获取当前协程的实例
//    resumeWithException：放下协程了，不吊他了，但会抛出异常（这相当于观察者模式的错误回调）
//    resume：恢复协程，放下协程了，告诉协程，我是成功的（这相当于观察者模式的成功回调）
    suspend fun requestData() : String =suspendCancellableCoroutine { continuation ->
        var disposable = getStarGazers(object : HttpResultObserver<List<User>>() {
            protected override fun onResult(resultBean: List<User>) {
                if(resultBean != null){
                    var gson = Gson()
                    Log.e("user disposable", gson.toJson(resultBean))
                   // continuation.resume(resultBean)
                }else{
                    continuation.resumeWithException(NullPointerException("Response Body is Null : $resultBean"))
                }

            }

            protected override fun onFailure(code: String, error: String) {
                //LogUtil.e("onFailure vcode:"+mView.getSmsParament().getVcode());
                continuation.resumeWithException(Throwable(error))
            }

        })
    }
}



