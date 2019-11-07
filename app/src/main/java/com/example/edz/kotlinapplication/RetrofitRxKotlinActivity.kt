package com.example.edz.kotlinapplication

import com.example.edz.kotlinapplication.R
import android.os.Bundle
import android.view.View
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity
import com.example.edz.kotlinapplication.actual.toast
import com.example.edz.kotlinapplication.apiservice.ApiErrorModel
import com.example.edz.kotlinapplication.apiservice.ApiResponse
import com.example.edz.kotlinapplication.apiservice.RequestCallback
import com.example.edz.kotlinapplication.data.ReposUser
import com.example.edz.kotlinapplication.service.NetworkScheduler
import com.example.edz.kotlinapplication.service.NetworkScheduler.compose
import com.example.edz.kotlinapplication.service.Service
import com.example.edz.kotlinapplication.service.User
import com.example.edz.kotlinapplication.service.api
import com.example.edz.kotlinapplication.util.OkHttpUtil
import com.trello.rxlifecycle3.android.ActivityEvent
import com.trello.rxlifecycle3.kotlin.bindUntilEvent
import kotlinx.android.synthetic.main.activity_retrofit_rx_kotlin.*
import java.io.File

class RetrofitRxKotlinActivity : RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit_rx_kotlin)

        tv.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View?) {
               // fetchRepo()
               // repos()
                upload()
            }
        })
    }

    private fun fetchRepo() {
        api.getRepos(this, object : ApiResponse<List<ReposUser>>(this) {
            override fun success(data: List<ReposUser>) { //请求成功，此处显示一些返回的数据
                userName.text = data[0].owner?.login
                repoName.text = data[0].name
                description.text = data[0].description
                url.text = data[0].html_url
            }

            override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) { //请求失败，此处直接显示Toast
                toast(apiErrorModel.message)
            }

        })

    }
    private fun repos() {
        api.repos(this, object : RequestCallback<List<ReposUser>>(this) {
            override fun success(data: List<ReposUser>) { //请求成功，此处显示一些返回的数据
                userName.text = data[0].owner?.login
                repoName.text = data[0].name
                description.text = data[0].description
                url.text = data[0].html_url
            }

            override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) { //请求失败，此处直接显示Toast
                toast(apiErrorModel.message)
            }

        })

    }


    fun upload(){
        var file = File("/")
        Service.gitHubService().updateImage(OkHttpUtil.createTextRequestBody("Bob"),
                OkHttpUtil.createPartWithAllImageFormats("avatar",file))   //此处调用OkHttpUtil中的方法
                .compose(NetworkScheduler.compose())
                .bindUntilEvent(this, ActivityEvent.DESTROY)
                .subscribe(object : ApiResponse<User>(this) {
                    override fun success(data: User) {
                        //Do something
                    }

                    override fun failure(statusCode: Int, apiErrorModel: ApiErrorModel) {
                        //Do something
                    }
                })
    }

}
