package edz.example.com.kotlinapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class CoroutinesActivity : AppCompatActivity() {
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)

        textView = findViewById(R.id.tv)

        textView.setOnClickListener(object: View.OnClickListener {
            override fun onClick(view: View?) {

            }
        })

    }



}



