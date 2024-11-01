package com.example.TeamNN.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.TeamNN.data.Screen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController=navController, startDestination = Screen.OnBoardingPage.route) {
        composable(route = Screen.BotNavBar.route) {
            BottomNavigationBar(navController)
        }
        composable(route = Screen.HomePage.route){
            HomePage(navController)
        }
        composable(route = Screen.SearchPage.route){
            SearchPage()
        }
        composable(route = Screen.ProfilePage.route){
            ProfilePage()
        }
        composable(route = Screen.OnBoardingPage.route) {
            OnBoardingScreen(navController)
        }
        composable(route = Screen.FilmPage.route) {
            ProfilePage()
        }

    }

}