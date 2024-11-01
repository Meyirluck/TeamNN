package com.example.TeamNN.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
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
        icon = Icons.Outlined.Home
    ),
    NavBarItem(
        name = "Search",
        route = "search_page",
//        icon = R.drawable.searchass
        icon = Icons.Outlined.Search
    ),
    NavBarItem(
        name = "Profile",
        route = "profile_page",
//        icon = R.drawable.profileass
        icon = Icons.Outlined.Person
)

)
