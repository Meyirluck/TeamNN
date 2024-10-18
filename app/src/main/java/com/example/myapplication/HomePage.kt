package com.example.myapplication


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.myapplication.ui.theme.data.MovieData
import com.example.myapplication.ui.theme.domain.MovieCard


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


@Composable
@Preview
fun MovieApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "movieList") {
        composable("movieList") {
            HomePage(navController = navController)
        }
        composable(
            "movieDetail/{name}/{genre}/{rating}/{image}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("genre") { type = NavType.StringType },
                navArgument("rating") { type = NavType.FloatType },
                navArgument("image") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            MovieCard().MovieDetailScreen(
                movieName = backStackEntry.arguments?.getString("name") ?: "",
                movieGenre = backStackEntry.arguments?.getString("genre") ?: "",
                movieRating = backStackEntry.arguments?.getDouble("rating") ?: 0.0,
                movieImage = backStackEntry.arguments?.getInt("image") ?: 0
            )
        }
    }
}



