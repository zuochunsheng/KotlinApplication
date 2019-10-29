package edz.example.com.kotlinapplication

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"
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

}
