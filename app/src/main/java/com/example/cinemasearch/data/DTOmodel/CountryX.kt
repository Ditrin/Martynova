package com.example.cinemasearch.data.DTOmodel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CountryX(
    val country: String
)