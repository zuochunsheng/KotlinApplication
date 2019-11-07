package com.example.edz.kotlinapplication.apiservice

/**
 * @author： zcs
 * @time：2019/11/7 on 19:16
 * @description：
 */

data class ResponseWrapper<T>(var code: Int, var data: T, var message: String)