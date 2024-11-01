package com.example.TeamNN.data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.TeamNN.presentation.ProfilePage

class MovieCard {
    @Composable
    fun DisplayMovie(movie: Movie, onClick: () -> Unit) {
        Box(
            modifier = Modifier
                .size(120.dp, 210.dp)
                .clickable(onClick = onClick)
        ) {
            Column(
                modifier = Modifier.padding(0.dp, 5.dp)
            ) {
                Box {
                    Image(
                        painter = painterResource(movie.image),
                        contentDescription = null,
                        modifier = Modifier
                            .size(126.dp, 165.dp)
                            .clip(RoundedCornerShape(6.dp))
                    )
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(6.dp)
                            .clip(RoundedCornerShape(2.dp))
                            .background(Color.Blue.copy(alpha = 0.7f))
                            .padding(horizontal = 2.dp, vertical = 1.dp)
                    ) {
                        Text(
                            text = movie.rating.toString(),
                            color = Color.White,
                            fontSize = 8.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
                Text(
                    movie.name,
                    style = TextStyle(fontSize = 15.sp)
                )
                Text(
                    movie.genre,
                    style = TextStyle(fontSize = 12.sp, color = Color.Gray)
                )
            }
        }
    }
    @Composable
    fun cate(category: String, list: List<Movie>, navController: NavController){
        Row(
            modifier = Modifier.fillMaxWidth().padding(0.dp, 10.dp),
            Arrangement.SpaceBetween
        ){
            Text(category, fontSize = 16.sp, fontWeight = FontWeight.Bold)

            Text("Все", color = Color.Blue)
        }
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(list) { movie ->
                DisplayMovie(movie) {
                    navController.navigate(
                        Screen.FilmPage.route
                    )
                }
            }
        }
    }
}