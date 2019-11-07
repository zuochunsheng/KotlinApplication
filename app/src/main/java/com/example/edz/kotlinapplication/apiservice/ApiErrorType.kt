package com.example.edz.kotlinapplication.apiservice

import android.content.Context
import androidx.annotation.StringRes
import com.example.edz.kotlinapplication.R

/**
 * @author： zcs
 * @time：2019/11/7 on 18:42
 * @description：
 */

enum class ApiErrorType(val code: Int, @param: StringRes private val messageId: Int) {
    //根据实际情况进行增删
    INTERNAL_SERVER_ERROR(500, R.string.service_error),
    BAD_GATEWAY(502, R.string.service_error),
    NOT_FOUND(404, R.string.not_found),
    CONNECTION_TIMEOUT(408, R.string.timeout),
    NETWORK_NOT_CONNECT(499, R.string.network_wrong),
    UNEXPECTED_ERROR(700, R.string.unexpected_error);

    private val DEFAULT_CODE = 1

    fun getApiErrorModel(context: Context): ApiErrorModel {
        return ApiErrorModel(DEFAULT_CODE, context.getString(messageId))
    }
}