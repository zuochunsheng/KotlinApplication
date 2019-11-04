package edz.example.com.kotlinapplication.service


import androidx.annotation.Keep

/**
 * @author： zcs
 * @time：2019/1/11 on 15:15
 * @description：
 */
@Keep
abstract class AbstractResultBean {


    abstract val code: String


    abstract val message: String

    abstract fun success(): Boolean

}
