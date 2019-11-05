package edz.example.com.kotlinapplication.actual

import android.annotation.SuppressLint
import android.app.Fragment
import android.content.Context
import android.widget.Toast

/**
 * anther: created by zuochunsheng on 2019/11/5 09 : 34
 * description :
 *
 */


// 扩展函数
inline fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}
@SuppressLint("NewApi")
inline fun Fragment.toast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
}


fun empty(x : String):Boolean{
   return   x != ""
}
