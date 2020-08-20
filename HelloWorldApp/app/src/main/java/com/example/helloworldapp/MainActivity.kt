package com.example.helloworldapp

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * メインアクティビティ <br />
 * 宿題
 *
 * @see "https://codelabs.developers.google.com/codelabs/android-training-layout-editor-part-b/index.html?index=..%2F..android-training#9"
 */
class MainActivity : AppCompatActivity() {

    companion object {
        /** カウントの初期値 */
        const val DEFAULT_COUNT = 0
    }

    /** 現在のカウント */
    private var mCount: Int = 0

    /** カウント表示テキストビュー */
    private var mShowCount: TextView? = null

    /** ゼロボタン */
    private var zeroButton: Button? = null

    /**
     * ライフサイクル 生成時
     *
     * @param savedInstanceState Bundle
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_work)
        Log.d("MainActivity", "Hello World");
        mShowCount = findViewById(R.id.show_count)
        zeroButton = findViewById(R.id.button_zero)
    }

    /**
     * カウントアップ
     * 奇数、偶数によってカウントボタンの色を変更する
     * ゼロボタンも活性化の色に変更する
     *
     * @param view View
     */
    fun countUp(view: View) {
        mCount++
        mShowCount?.let {
            it.text = mCount.toString()
            view.setBackgroundColor(if (mCount % 2 == 1) Color.RED else Color.BLUE)
        }
        zeroButton?.setBackgroundColor(Color.CYAN)
    }

    /**
     * トースト表示
     * @param view View
     */
    fun showToast(view: View) {
        val toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT)
        toast.show()
    }

    /**
     * カウントを0に設定して、ボタンの背景色も非活性の色に変更
     *
     * @param view View
     */
    fun countZero(view: View) {
        mShowCount?.let {
            it.text = DEFAULT_COUNT.toString()
        }
        mCount = DEFAULT_COUNT
        view.setBackgroundColor(Color.GRAY)
    }
}