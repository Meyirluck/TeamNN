package com.example.assignment2.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Search
import androidx.compose.ui.graphics.vector.ImageVector

data class NavBarItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val BarItems: List<NavBarItem> = listOf(
    NavBarItem(
        name = "Home",
        route = "home_page",
//        icon = R.drawable.homeass
        icon = Icons.Rounded.Home
    ),
    NavBarItem(
        name = "Search",
        route = "search_page",
//        icon = R.drawable.searchass
        icon = Icons.Rounded.Search
    ),
    NavBarItem(
        name = "Profile",
        route = "profile_page",
//        icon = R.drawable.profileass
        icon = Icons.Rounded.Person
)

)
