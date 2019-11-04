package edz.example.com.kotlinapplication.service

import android.text.TextUtils


/**
 * @author： zcs
 * @time：2019/9/24 on 15:49
 * @description：
 */
class ResultBean<T> : AbstractResultBean() {
    override val code: String? = null
    override val message: String? = null
    val data: T? = null

    override fun success(): Boolean {
        return TextUtils.equals(code, "000000")
    }


}
