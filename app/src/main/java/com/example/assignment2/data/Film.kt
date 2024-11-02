package com.example.TeamNN.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Film(
    @SerialName("posterUrl")
    val poster: String,
    @SerialName("nameRu")
    val name: String,
    @SerialName("genres")
    val genres: List<Genre>,
    @SerialName("ratingImdb")
    val rating: Double? = null
)