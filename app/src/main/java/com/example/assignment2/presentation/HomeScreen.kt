package com.example.TeamNN.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.TeamNN.R
import com.example.TeamNN.data.Film

import com.example.TeamNN.data.Screen
import com.example.TeamNN.data.UiState

@Composable
fun HomeScreen(
    navController: NavController,
    UiState: UiState,
    modifier: Modifier = Modifier
) {
    val categories = listOf("Popular","Top-250")
    when (UiState) {
        is UiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
        is UiState.Success ->
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(categories.size){ index -> cate(categories[index],UiState.categories[index], navController = navController)
                }
            }
        is UiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())
    }
}


@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "loading"
    )
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "loading_failed", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun DisplayMovie(movie: Film, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(120.dp, 210.dp)
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier.padding(0.dp, 5.dp)
        ) {
            Box {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(movie.poster)
                            .crossfade(true)
                            .build(),
                        error = painterResource(R.drawable.ic_broken_image),
                        placeholder = painterResource(R.drawable.loading_img),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
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
                movie.genres.get(0).toString(),
                style = TextStyle(fontSize = 12.sp, color = Color.Gray)
            )
        }
    }
}
@Composable
fun cate(category: String, list: List<Film>, navController: NavController){
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
        val catlist = list.subList(0,3)
        items(catlist) { movie ->
            DisplayMovie(movie) {
                navController.navigate(
                    Screen.FilmPage.route
                )
            }
        }
    }
}


