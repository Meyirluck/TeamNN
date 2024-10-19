package com.example.assignment2.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.assignment2.data.Screen

@Composable
fun Navigation(navController: NavHostController){

    NavHost(navController=navController, startDestination = Screen.HomePage.route) {
        composable(route = Screen.HomePage.route){
            HomePage(navController = navController)
        }
        composable(route = Screen.SearchPage.route){
            SearchPage()
        }
        composable(route = Screen.ProfilePage.route){
            ProfilePage()
        }

    }

}