package edz.example.com.kotlinapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayMessageActivity : AppCompatActivity() {

    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val message = intent.getStringExtra(EXTRA_MESSAGE_MAIN)
        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

    }




}
