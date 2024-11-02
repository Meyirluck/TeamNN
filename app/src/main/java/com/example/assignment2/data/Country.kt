package com.example.TeamNN.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Country(
    @SerialName("country")
    val country: String
)
