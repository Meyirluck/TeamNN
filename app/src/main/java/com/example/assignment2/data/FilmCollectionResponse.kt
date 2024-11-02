package com.example.TeamNN.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmCollectionResponse(
    @SerialName("total")
    val total: Int,
    @SerialName("totalPages")
    val totalPages: Int,
    @SerialName("items")
    val items: List<Film>
)



@Serializable
data class Genre(
    val genre: String
)