package com.example.droidcafe

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {


    var mOrderMessage: String? = null

    companion object {
        val EXTRA_MESSAGE = "com.example.android.droidcafe.extra.MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        fab.setOnClickListener {
            val intent = Intent(this, OrderActitivy::class.java).apply {
                putExtra(EXTRA_MESSAGE, mOrderMessage)
            }
            startActivity(intent)
        }

//        Glide.with(this).load("https://growthseed.jp/wp-content/uploads/2016/12/peach-1.jpg")
//            .into(donut)

    }

    fun displayToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun showDonutOrder(view: View) {
        mOrderMessage = getString(R.string.donut_order_message)
        displayToast(mOrderMessage!!)
    }

    fun showIceCreamOrder(view: View) {
        mOrderMessage = getString(R.string.ice_cream_order_message)
        displayToast(mOrderMessage!!)
    }

    fun showFroyoOrder(view: View) {
        mOrderMessage = getString(R.string.froyo_order_message)
        displayToast(mOrderMessage!!)
    }
}