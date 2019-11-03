package edz.example.com.kotlinapplication.service

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.telecom.Call

/**
 * anther: created by zuochunsheng on 2019/11/3 15 : 01
 * description :
 *
 */


interface GitHubService{

    @Get("/repos/enbandari/Kotlin-Tutorals/stargazers")
    fun getStarGazers(): Call<List<User>>
}

object Service{

    var gitHubService :GitHubService by lazy{

        Retrofit.Builder().baseUrl("https://api.github.com")
                .addConverterFatory(GsonConverterFactory.create())
                .build().create(GitHubService::class.java)
    }
}

fun main(args:Array<String>){
    Service.gitHubService.getStarGazers().execute().body().map(::println)
}