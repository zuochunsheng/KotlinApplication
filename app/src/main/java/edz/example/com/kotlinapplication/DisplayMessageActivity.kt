package edz.example.com.kotlinapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class DisplayMessageActivity : AppCompatActivity() {

    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"
    val GAME_STATE_KEY = "com.example.edz.kotlinapplication.GAME"
    val TEXT_VIEW_KEY = "com.example.edz.kotlinapplication.TEXT"

    lateinit var textView: TextView

    var gameState: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        gameState = savedInstanceState?.getString(GAME_STATE_KEY)

        setContentView(R.layout.activity_display_message)
        textView = findViewById(R.id.textView)

        val message = intent.getStringExtra(EXTRA_MESSAGE_MAIN)
        textView?.apply {
            text = message
        }

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        textView.text = savedInstanceState?.getString(TEXT_VIEW_KEY)
    }
    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.run {
            putString(GAME_STATE_KEY, gameState)
            putString(TEXT_VIEW_KEY, textView.text.toString())
        }
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState)
    }







}
