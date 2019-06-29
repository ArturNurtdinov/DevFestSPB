package com.example.devfestspb.data

import android.os.Parcel
import android.os.Parcelable

data class Speaker(var id: String) : Parcelable {
    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var location: String
    lateinit var jobTitle: String
    lateinit var company: String
    lateinit var about: String
    lateinit var photo: String
    lateinit var flagImage: String
    lateinit var twitter: String

    constructor(parcel: Parcel) : this(parcel.readString()!!) {
        firstName = parcel.readString()!!
        lastName = parcel.readString()!!
        location = parcel.readString()!!
        jobTitle = parcel.readString()!!
        company = parcel.readString()!!
        about = parcel.readString()!!
        photo = parcel.readString()!!
        flagImage = parcel.readString()!!
        twitter = parcel.readString()!!
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(location)
        parcel.writeString(jobTitle)
        parcel.writeString(company)
        parcel.writeString(about)
        parcel.writeString(photo)
        parcel.writeString(flagImage)
        parcel.writeString(twitter)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Speaker> {
        override fun createFromParcel(parcel: Parcel): Speaker {
            return Speaker(parcel)
        }

        override fun newArray(size: Int): Array<Speaker?> {
            return arrayOfNulls(size)
        }
    }
}