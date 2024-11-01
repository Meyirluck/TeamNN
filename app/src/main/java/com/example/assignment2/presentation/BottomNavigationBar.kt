package com.example.TeamNN.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.TeamNN.data.BarItems

@Composable
fun BottomNavigationBar(navController: NavController){

    var selectedIndex by remember{
        mutableIntStateOf(0)
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar(
                containerColor = Color.White
            ) {
                BarItems.forEachIndexed { index, navBarItem ->
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {
                            Icon(
                                imageVector = navBarItem.icon,
                                contentDescription = "Icon",
                                tint = if(selectedIndex == index)  Color(0xff3d3bff)
                                else Color(0xff272727)
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        ActiveScreen(modifier = Modifier.padding(innerPadding),selectedIndex, navController = navController)
    }
}

@Composable
fun ActiveScreen(modifier: Modifier, selectedIndex: Int, navController: NavController){
    when(selectedIndex){
        0-> HomePage(navController = navController)
        1-> SearchPage()
        2-> ProfilePage()
    }
}