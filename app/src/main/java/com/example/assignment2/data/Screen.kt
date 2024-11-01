package com.example.TeamNN.data

sealed class Screen(val route: String) {
    object HomePage: Screen("home_page")
    object ProfilePage: Screen("profile_page")
    object SearchPage: Screen("search_page")
    object OnBoardingPage: Screen("onboarding_page")
    object FilmPage: Screen("film_page")
    object BotNavBar: Screen("BotNavBar")
}
