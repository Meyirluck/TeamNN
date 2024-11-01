package com.example.TeamNN.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.TeamNN.R
import com.example.TeamNN.data.OnBoardingPage
import com.example.TeamNN.data.Screen
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    val pagerState = rememberPagerState()
    val scope = rememberCoroutineScope()
    val pages = listOf(
        OnBoardingPage("Узнавай о премьерах", R.drawable.netflix),
        OnBoardingPage("Создавай коллекции", R.drawable.women),
        OnBoardingPage("Делись с друзьями", R.drawable.ebbccf2b115e5459d1cdb09409748aee)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
    ) {

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp, start = 20.dp),
            Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Text(
                text = "Skillcinema",
                fontSize = 20.sp
            )

            TextButton(
                onClick = {
                    if (pagerState.currentPage < pages.size - 1) {
                        scope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    }
                    else{
                        navController.navigate(Screen.BotNavBar.route)
                    }
                },
            ) {
                Text(text = "Пропустить", fontSize = 15.sp, color = Color.Gray)
            }

        }

        HorizontalPager(
            count = pages.size,
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { page ->
            OnBoardingPageUI(page = pages[page])
        }

        CustomPagerIndicator(pagerState = pagerState, pageCount = pages.size)
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CustomPagerIndicator(pagerState: PagerState, pageCount: Int) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        for (i in 0 until pageCount) {
            val color = if (i == pagerState.currentPage) Color.Black else Color.Gray
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .padding(4.dp)
                    .background(color, CircleShape)
            )
        }
    }
}


