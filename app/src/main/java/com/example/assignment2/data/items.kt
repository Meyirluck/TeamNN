package com.example.TeamNN.data

import kotlinx.serialization.Serializable

@Serializable
data class FilmCollectionResponse(
    val total: Int,
    val totalPages: Int,
    val items: List<FilmCollectionResponse_items>
)

data class FilmCollectionResponse_items(
    val kinopoiskId: String,
    val nameRu: String,
    val nameEn: String,
    val nameOriginal: String,
    val countries: List<Country>,
    val genres: List<Genre>,
    val ratingKinopoisk: Double,
    val ratingImbd: Double,
    val year: String,
    val type: String,
    val posterUrl: String,
    val posterUrlPreview: String
)
