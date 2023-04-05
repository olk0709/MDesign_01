package com.example.mdesign_01.model

import com.google.gson.annotations.SerializedName

data class PictureOfTheDayResponseData(
    val copyright: String,
    val date: String,
    val explanation: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String,
    val title: String,
    val url: String
)