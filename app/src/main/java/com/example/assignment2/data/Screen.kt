package com.example.assignment2.data

sealed class Screen(val route: String) {
    object HomePage: Screen("home_page")
    object ProfilePage: Screen("profile_page")
    object SearchPage: Screen("search_page")
//    object
}
