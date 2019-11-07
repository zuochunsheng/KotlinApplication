package edz.example.com.kotlinapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import edz.example.com.kotlinapplication.service.HttpResultObserver
import edz.example.com.kotlinapplication.service.User
import edz.example.com.kotlinapplication.service.api

//kotlin 封装：
fun <V : View> Activity.bindView(id: Int): Lazy<V> = lazy {
    viewFinder(id) as V
}

//acitivity中扩展调用
private val Activity.viewFinder: Activity.(Int) -> View?
    get() = { findViewById(it) }


class MainActivity : AppCompatActivity() {


    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"

    //在activity中的使用姿势
    val mTextView by bindView<TextView>(R.id.tv_text)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun skipNext(view: View) {

        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        // 为 Intent extra 定义键时，最好使用应用的软件包名称作为前缀。这样可以确保这些键是独一无二的，以便您的应用与其他应用进行交互。
        val intent = Intent(this, DisplayMessageActivity::class.java)
                .apply { putExtra(EXTRA_MESSAGE_MAIN, message) }
        startActivity(intent)
    }
    fun skipNextCoroutine(view: View){
        val intent = Intent(this, CoroutinesActivity::class.java)
        startActivity(intent)
    }

    fun initByUser(view: View) {

        mTextView.text = "执行到我时，才会进行控件初始化"
        mTextView.textSize = 23f
        mTextView.gravity = Gravity.CENTER

        with(mTextView) {
            text = "执行到我时，才会进行控件初始化"
            textSize = 23f
            gravity = Gravity.CENTER
        }

    }

}
