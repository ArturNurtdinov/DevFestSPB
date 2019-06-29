package com.example.devfestspb

import android.content.Context
import android.content.Intent
import com.example.devfestspb.data.Speaker
import com.example.devfestspb.data.Talk

class MainPresenter(var context: Context) {
    private val repository = Repository()
    var speakerList: ArrayList<Speaker>
    private var talksList: ArrayList<Talk>

    init {
        talksList = repository.talksElements
        speakerList = repository.speakerElements
    }

    val clickListener: (Speaker) -> Unit = {
        openReportActivity(it, getTalkObjectById(it.id))
    }

    private fun getTalkObjectById(id: String): Talk {
        return talksList.find { it.speakerId == id }!!
    }

    private fun openReportActivity(speaker: Speaker, talk: Talk) {
        val intent = Intent(context, AboutAuthorsActivity::class.java)
        intent.putExtra(AboutAuthorsActivity.SPEAKER_KEY, speaker)
        intent.putExtra(AboutAuthorsActivity.TALK_KEY, talk)
        context.startActivity(intent)
    }
}