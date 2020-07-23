package com.andresaftari.submissionfinal.data.remote.response

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataResponse(
    val id: String,
    val title: String,
    val genre: String,
    val description: String,
    val imagePath: String
) : Parcelable