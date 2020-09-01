package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    private val LOG_TAG = SecondActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        // getterを呼び出してるだけでオブジェクトが存在しているわけではない
        text_message.text = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        Log.d(LOG_TAG, "-------");
        Log.d(LOG_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    fun returnReply(view: View) {
        val intent = Intent().putExtra(EXTRA_SECOND, editText_second.text.toString())
        setResult(Activity.RESULT_OK, intent)
        Log.d(LOG_TAG, "End SecondActivity");
        finish()
    }


    companion object {
        private const val EXTRA_MESSAGE = "key"
        const val EXTRA_SECOND = "second_key"


        // アクティビティ呼び出しメソッド
        fun start(
            context: ComponentActivity,
            message: String,
            callback: (ActivityResult?) -> Unit
        ) {
            // ここもjavaまでいれます
            val intent = Intent(context, SecondActivity::class.java).apply {
                putExtra(
                    MainActivity.EXTRA_MESSAGE,
                    message
                )
            }

            val launcher =
                context.registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
                    callback(it)
                }

            launcher.launch(intent)
        }
    }
}