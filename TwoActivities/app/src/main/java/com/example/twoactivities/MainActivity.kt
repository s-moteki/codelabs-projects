package com.example.twoactivities

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    companion object {
        // Kotlinのではなくjavaの方のGetterを呼び出す
        private val LOG_TAG = MainActivity::class.java.simpleName
        const val EXTRA_MESSAGE = "com.example.android.twoactivities.extra.MESSAGE"
        const val REQUEST_CODE = 1
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (text_message_reply.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", text_message_reply.text.toString());
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
        if (savedInstanceState != null) {
            if (savedInstanceState.getBoolean("reply_visible")) {
                text_message_reply.text = savedInstanceState.getString("reply_text")
                text_message_reply.visibility = View.VISIBLE
                text_header_reply.visibility = View.VISIBLE
            }
        }
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

    // アクティビティから値を受け取る
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // リクエストコードとリザルトの判定
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            text_header_reply.text = data?.getStringExtra(SecondActivity.EXTRA_SECOND)
            text_message_reply.visibility = View.VISIBLE
            text_header_reply.visibility = View.VISIBLE
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        SecondActivity.start(this, editText_main.text.toString()) {
            if (it?.resultCode == Activity.RESULT_OK) {
                text_message_reply.text = it.data?.getStringExtra(SecondActivity.EXTRA_SECOND)
                text_message_reply.visibility = View.VISIBLE
                text_header_reply.visibility = View.VISIBLE
            }
        }
    }
}