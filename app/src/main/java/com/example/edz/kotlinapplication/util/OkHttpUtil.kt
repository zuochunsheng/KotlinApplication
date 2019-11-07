package com.example.edz.kotlinapplication.util

import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File

/**
 * @author： zcs
 * @time：2019/11/7 on 18:10
 * @description：上传图片
 */
object OkHttpUtil {
    fun createTextRequestBody(source: String): RequestBody
            = RequestBody.create(MediaType.parse("text/plain"), source)

    fun createPartWithAllImageFormats(requestKey: String, file: File): MultipartBody.Part
            = MultipartBody.Part
            .createFormData(requestKey, file.name, RequestBody.create(MediaType.parse("image/*"), file))
}