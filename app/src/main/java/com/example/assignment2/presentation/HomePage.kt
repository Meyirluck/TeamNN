package com.example.TeamNN.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.TeamNN.data.MovieCard
import com.example.TeamNN.data.MovieData


@Composable
fun HomePage(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(25.dp, 20.dp)
    ) {
        item {
            Text(
                "SkillCinema",
                modifier = Modifier
                    .padding(0.dp, 30.dp),
                style = TextStyle(
                    fontSize = 28.sp
                )
            )
            val movieData = MovieData()
            val movieCard = MovieCard()
            movieCard.cate("Премьеры", movieData.getMovies(), navController)
            movieCard.cate("Популярные", movieData.getMovies(), navController)
            movieCard.cate("Боевики США", movieData.getMovies(), navController)
            movieCard.cate("Топ 250", movieData.getMovies(), navController)
            movieCard.cate("Драмы Франций", movieData.getMovies(), navController)
            movieCard.cate("Сериалы", movieData.getMovies(), navController)
        }
    }
}






