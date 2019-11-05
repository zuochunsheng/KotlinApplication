package edz.example.com.kotlinapplication.service


import android.util.Log
import edz.example.com.kotlinapplication.service.Service.gitHubService
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.X509TrustManager


/**
 * anther: created by zuochunsheng on 2019/11/3 15 : 01
 * description :
 * https://api.github.com/repos/bingoogolapple/BGAQRCode-Android/watchers
 */

private var mBaseUrl = "https://api.github.com/"
//private var retrofit: Retrofit = null
private var mOkHttpClient: OkHttpClient? = null


interface GitHubService {

    @GET("repos/bingoogolapple/BGAQRCode-Android/watchers")
    fun getStarGazersUnit(): Observable<List<User>>


    @GET("repos/bingoogolapple/BGAQRCode-Android/watchers")
    fun getStarGazers(): Observable<List<User>>


}

object Service {

    /* 请求超时时间 */
    private val TIME_OUT_PERIOD = 60
    private var trustManagers = arrayOf(object : X509TrustManager {
        @Throws(CertificateException::class)
        override fun checkClientTrusted(x509Certificates: Array<X509Certificate>, s: String) {

        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(x509Certificates: Array<X509Certificate>, s: String) {

        }

        override fun getAcceptedIssuers(): Array<X509Certificate?> {
            return arrayOfNulls(0)
        }
    })


    @NonNull
    private fun getBuilder(isHttpsSSL: Boolean): OkHttpClient.Builder {
        /* 对 okhttpClient 进行初始化 */
        val builder = OkHttpClient.Builder().retryOnConnectionFailure(false)
        builder.connectTimeout(TIME_OUT_PERIOD.toLong(), TimeUnit.SECONDS) // 设置连接超时时间 60 秒
        builder.readTimeout(TIME_OUT_PERIOD.toLong(), TimeUnit.SECONDS) // 设置读取超时时间 60 秒
        builder.writeTimeout(TIME_OUT_PERIOD.toLong(), TimeUnit.SECONDS) // 设置写入超时时间 60 秒

        //日志显示级别
        val level = HttpLoggingInterceptor.Level.BODY
        //新建log拦截器
        val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
            Log.e("zcs", "OkHttp====Message:$it")

        })
        loggingInterceptor.setLevel(level)
        //OkHttp进行添加拦截器loggingInterceptor
        builder.addInterceptor(loggingInterceptor)
        // https 忽略证书验证
        if (isHttpsSSL) {
            var sslContext: SSLContext? = null
            try {
                sslContext = SSLContext.getInstance("SSL")

            } catch (e: NoSuchAlgorithmException) {
                e.printStackTrace()
            }

            try {
                sslContext!!.init(null, trustManagers, SecureRandom())
            } catch (e: KeyManagementException) {
                e.printStackTrace()
            }

            val DO_NOT_VERIFY = HostnameVerifier { hostname, session -> true }
            val sslSocketFactory = sslContext?.socketFactory
            builder.sslSocketFactory(sslSocketFactory)
            builder.hostnameVerifier(DO_NOT_VERIFY)
        }
        return builder
    }

    /**
     * @return OkHttpclient
     */
    fun createDefaultClient(): OkHttpClient {
        val builder = getBuilder(true)
        return builder.build()
    }

    fun createRetrofit(): Retrofit {
        /* 对 retrfit 进行建造 */
//    var retrofit :Retrofit  by lazy {
//
//    }
        return Retrofit.Builder()
                .client(createDefaultClient())
                .baseUrl(mBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun gitHubService(): GitHubService {
        return createRetrofit().create(GitHubService::class.java)
    }

}

object api {

    fun getStarGazersUnit(observer: Observer<List<User>>): Unit {
        gitHubService().getStarGazersUnit()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    fun getStarGazers(observer: HttpResultObserver<List<User>>): Disposable {
        return gitHubService().getStarGazers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
    }

}


fun main(args: Array<String>) {

    api.getStarGazersUnit(object: Observer<List<User>> {


        override fun onSubscribe(d: Disposable) {

        }

        override fun onError(e: Throwable) {

        }

        override fun onNext(t: List<User>) {

        }

        override fun onComplete() {

        }

    })

    var disposable = api.getStarGazers(object : HttpResultObserver<List<User>>() {
        protected override fun onResult(resultBean: List<User>) {
            println(resultBean)
        }

        protected override fun onFailure(code: String, error: String) {
            //LogUtil.e("onFailure vcode:"+mView.getSmsParament().getVcode());

        }

    })



}