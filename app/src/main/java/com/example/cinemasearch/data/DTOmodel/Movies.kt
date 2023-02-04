package com.example.cinemasearch.data.DTOmodel

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)

data class Movies(
    val films: List<Film>,
    val pagesCount: Int
)