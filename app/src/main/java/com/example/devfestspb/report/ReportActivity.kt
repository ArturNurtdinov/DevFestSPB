package com.example.devfestspb.report

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.devfestspb.MainActivity
import com.example.devfestspb.R


class ReportActivity : AppCompatActivity() {

    companion object {
        const val AUTHOR_KEY = "AUTHOR_KEY"
        const val TAG_KEY = "TAG_KEY"
        const val REPORT_KEY = "REPORT_KEY"
        const val TITLE_KEY = "TITLE_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = this.intent
        val author = intent.getStringExtra(AUTHOR_KEY)
        val tag = intent.getStringExtra(TAG_KEY)
        val rep = intent.getStringExtra(REPORT_KEY)
        val title = intent.getStringExtra(TITLE_KEY)
        val titleView = findViewById<TextView>(R.id.title)
        titleView.text = title
        val authorView = findViewById<TextView>(R.id.author_name)
        authorView.text = author
        val tagFirstView = findViewById<TextView>(R.id.tag1)
        tagFirstView.text = tag
        if (tag == "Frontend")
            tagFirstView.setBackgroundColor(resources.getColor(R.color.colorBlue))
        else if (tag == "Android")
            tagFirstView.setBackgroundColor(resources.getColor(R.color.colorAccent))
        val reportView = findViewById<TextView>(R.id.report_field)
        reportView.text = rep

        val backToAllReps = findViewById<Button>(R.id.back_to_all_reports)
        backToAllReps.setOnClickListener {
            val intentBack = Intent(this, MainActivity::class.java)
            startActivity(intentBack)
        }
    }
}
