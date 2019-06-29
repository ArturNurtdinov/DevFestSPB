package com.example.devfestspb

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.devfestspb.data.Speaker
import com.example.devfestspb.data.Talk
import com.squareup.picasso.Picasso
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class AboutAuthorsActivity : AppCompatActivity() {

    companion object {
        const val SPEAKER_KEY = "SPEAKERS"
        const val TALK_KEY = "TALKS"
    }
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) = runBlocking {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_authors)
        /*val imageTelegram = findViewById<ImageView>(R.id.imageTelegram)
        imageTelegram.setOnClickListener { openMyTelegram() }*/
        val intent = this@AboutAuthorsActivity.intent
        val speaker = intent.getParcelableExtra<Speaker>(SPEAKER_KEY)
        val talk = intent.getParcelableExtra<Talk>(TALK_KEY)
        val avatar = findViewById<ImageView>(R.id.avatar)
        async { setAvatar(speaker.photo, avatar) }
        val nameTV = findViewById<TextView>(R.id.full_name)
        val specTV = findViewById<TextView>(R.id.specialization)
        val locationTV = findViewById<TextView>(R.id.university)
        val infoTV = findViewById<TextView>(R.id.info_about_person)
        val reportTV = findViewById<TextView>(R.id.report_title)
        val roomTV = findViewById<TextView>(R.id.room_number)
        val tagTV = findViewById<TextView>(R.id.tag)
        val timeTV = findViewById<TextView>(R.id.report_time)
        val telegramIcon = findViewById<ImageView>(R.id.image_twitter)

        nameTV.text = speaker.firstName + " " + speaker.lastName
        specTV.text = speaker.jobTitle
        locationTV.text = speaker.location
        infoTV.text = talk.description
        reportTV.text = talk.title
        roomTV.text = "Room " + talk.room.toString()
        timeTV.text = talk.time
        if (talk.track != ""){
            tagTV.text = talk.track
        }
        when (talk.track){
            "common" -> tagTV.setBackgroundColor(resources.getColor(R.color.colorGray))
            "Android" -> tagTV.setBackgroundColor(resources.getColor(R.color.colorMagneta))
            "Frontend" -> tagTV.setBackgroundColor(resources.getColor(R.color.colorBlue))
        }
        if (speaker.twitter != ""){
            telegramIcon.visibility = View.VISIBLE
            telegramIcon.setOnClickListener{
                openUrl(speaker.twitter)
            }
        }
    }

    private fun setAvatar(URL: String, into: ImageView){
        Picasso.get()
            .load(URL)
            .into(into)
    }

    private fun openUrl(url: String) {
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
}
