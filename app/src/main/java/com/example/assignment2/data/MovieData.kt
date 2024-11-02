package com.example.TeamNN.data

import com.example.TeamNN.R


class MovieData {
    val premieres = listOf(
        Movie(
            8.6,
            R.drawable.img,
            "Titanic",
            "Drama"
        ),
        Movie(
            8.2,
            R.drawable.img,
            "1+1",
            "Comedy"
        ),
        Movie(
            8.7,
            R.drawable.img,
            "Avengers 3",
            "Fantasy"
        ),
        Movie(7.4,
            R.drawable.img,
            "Sinister",
            "Horror"
        ),
        Movie(
            8.6,
            R.drawable.img,
            "Titanic",
            "Drama"
        ),
        Movie(
            8.2,
            R.drawable.img,
            "1+1",
            "Comedy"
        ),
        Movie(
            8.7,
            R.drawable.img,
            "Avengers: The Infinity War",
            "Fantasy"
        ),
        Movie(7.4,
            R.drawable.img,
            "Sinister",
            "Horror"
        )
    )
    fun getMovies(): List<Movie> {
        return premieres
    }
}

data class Movie(
    val rating: Double,
    val image: Int,
    val name: String,
    val genre: String
)