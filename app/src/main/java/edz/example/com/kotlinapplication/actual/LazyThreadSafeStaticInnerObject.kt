package edz.example.com.kotlinapplication.actual

/**
 * @author： zcs
 * @time：2019/10/29 on 18:54
 * @description：单例
 */
class LazyThreadSafeStaticInnerObject private constructor(){
    companion object {
        fun getInstance() = Holder.instance
    }
    private object Holder{
        var instance = LazyThreadSafeStaticInnerObject()
    }


}