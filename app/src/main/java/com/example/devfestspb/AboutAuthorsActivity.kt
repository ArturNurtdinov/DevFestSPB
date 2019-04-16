package com.example.devfestspb

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.content.Intent
import android.net.Uri


class AboutAuthorsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_authors)
        val imageTelegram = findViewById<ImageView>(R.id.imageTelegram)
        imageTelegram.setOnClickListener { openMyTelegram() }
    }

    fun openMyTelegram() {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/viruskuls"))
        startActivity(browserIntent)
    }
}
