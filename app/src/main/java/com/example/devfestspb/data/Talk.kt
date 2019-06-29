package com.example.devfestspb.data

import android.os.Parcel
import android.os.Parcelable

data class Talk(var speakerId: String): Parcelable {
    lateinit var description: String
    lateinit var title: String
    var room: Int = 0
    lateinit var track: String
    lateinit var time: String

    constructor(parcel: Parcel) : this(parcel.readString()!!) {
        description = parcel.readString()!!
        title = parcel.readString()!!
        room = parcel.readInt()
        track = parcel.readString()!!
        time = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(speakerId)
        parcel.writeString(description)
        parcel.writeString(title)
        parcel.writeInt(room)
        parcel.writeString(track)
        parcel.writeString(time)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Talk> {
        override fun createFromParcel(parcel: Parcel): Talk {
            return Talk(parcel)
        }

        override fun newArray(size: Int): Array<Talk?> {
            return arrayOfNulls(size)
        }
    }

}