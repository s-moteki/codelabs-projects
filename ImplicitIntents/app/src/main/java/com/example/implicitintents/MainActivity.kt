package com.example.implicitintents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openWebsite(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(website_edittext.text.toString()))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }


    fun openLocation(view: View) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${location_edittext.text}"))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }

    }


    fun shareText(view: View) {
        ShareCompat.IntentBuilder.from(this).setType("text/plain")
            .setChooserTitle("Share this text with: ").setText(share_edittext.text.toString())
            .startChooser()
    }
}