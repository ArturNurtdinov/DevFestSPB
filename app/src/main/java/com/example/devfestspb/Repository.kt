package com.example.devfestspb

import com.example.devfestspb.data.Speaker
import com.example.devfestspb.data.Talk
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import kotlin.collections.ArrayList

class Repository {
    private val client = OkHttpClient()
    var speakerElements: ArrayList<Speaker> = arrayListOf()
    var talksElements: ArrayList<Talk> = arrayListOf()

    init {
        loadData()
    }

    private fun loadData() {
        val request = Request.Builder()
            .url("https://storage.yandexcloud.net/devfestapi/data.json")
            .build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                val jsonObject = JSONObject(response.body()!!.string())

                val jsonArray = jsonObject.getJSONArray("speakers")
                for (i in 0 until jsonArray.length()) {
                    val speakerObject = jsonArray.getJSONObject(i)
                    val id = speakerObject.getString("id")
                    var job: String
                    job = try {
                        speakerObject.getString("jobTitle")
                    } catch (e: JSONException) {
                        "Senior Developer" // id = "konstantin-tskhovrebov"
                    }
                    val speaker = Speaker(id)
                    speaker.jobTitle = job
                    speaker.firstName = speakerObject.getString("firstName")
                    speaker.lastName = speakerObject.getString("lastName")
                    speaker.about = speakerObject.getString("about")
                    speaker.company = speakerObject.getString("company")
                    speaker.photo = speakerObject.getString("photo")
                    speaker.flagImage = speakerObject.getString("flagImage")
                    speaker.location = speakerObject.getString("location")
                    val links = speakerObject.getJSONObject("links")
                    val link: String = try {
                        links.getString("twitter")
                    } catch (e: JSONException) {
                        ""
                    }
                    speaker.twitter = link
                    speakerElements.add(speaker)
                }

                val schedule = jsonObject.getJSONObject("schedule")
                val scheduleArr = schedule.getJSONArray("talks")
                for (i in 0 until scheduleArr.length()) {
                    val talks = scheduleArr.getJSONObject(i)
                    val speakerId = talks.getString("speaker")
                    val talk = Talk(speakerId)
                    talk.title = talks.getString("title")
                    talk.description = talks.getString("description")
                    talk.room = talks.getInt("room")
                    talk.time = talks.getString("time")
                    talk.track = talks.getString("track")
                    talksElements.add(talk)
                }
            }
        })
    }
}