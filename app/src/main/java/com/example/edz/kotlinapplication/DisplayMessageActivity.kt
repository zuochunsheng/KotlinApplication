package com.example.edz.kotlinapplication

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.edz.kotlinapplication.actual.Preference
import com.example.edz.kotlinapplication.actual.toast


class DisplayMessageActivity : AppCompatActivity() {

    val EXTRA_MESSAGE_MAIN = "com.example.edz.kotlinapplication.MESSAGE"
    val GAME_STATE_KEY = "com.example.edz.kotlinapplication.GAME"
    val TEXT_VIEW_KEY = "com.example.edz.kotlinapplication.TEXT"

    companion object {


    }


    lateinit var textView: TextView

    var gameState: String? = null

    //调用处
//    private var zipCode by DelegatesExt.preference(this, "zipCode_key", 100L)
//    private var mGuideEnable  by DelegatesExt.preference(this,"guide_key", false)
//    private var setValue  by DelegatesExt.preference(this,"set_key",setOf("Android", "Ios"))

    private var numCodeValue by Preference("numCode_key", 0)
    private var booleanValue  by Preference("boolean_key", false)
    private var setValue  by Preference("set_key",setOf(""))
    private var stringValue  by Preference("string_key","")

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

//    override fun onSaveInstanceState(outState: Bundle?) {
//        outState?.run {
//            putString(GAME_STATE_KEY, gameState)
//            putString(TEXT_VIEW_KEY, textView.text.toString())
//        }
//        // call superclass to save any view hierarchy
//        super.onSaveInstanceState(outState)
//    }
    // let with run / apply also

    fun sp_put(view: View) {
        numCodeValue += 1000
        booleanValue = true
        setValue = setOf("abc", "def","123")
        stringValue += "String"

    }

    fun sp_get(view: View) {

        textView.text = numCodeValue.toString()
                        .plus(booleanValue)
                        .plus(setValue.toString())
                        .plus(stringValue)


    }
    fun sp_remove(view: View) {
        //val remove = Preference().remove("guide_key")

        val prefs: Preference<String> = Preference()
        prefs.remove("numCode_key")
        prefs.remove("string_key")

    }
    fun sp_clear(view: View) {
       // App.instance.applicationContext

       // Preference<SharedPreferences>().clear()

        val prefs = Preference<String>()
        prefs.clear()
        //clear 之后再获取 是默认值

        toast("clear")
    }


}
