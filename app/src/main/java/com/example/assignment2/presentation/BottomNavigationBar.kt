package com.example.assignment2.presentation

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
import androidx.navigation.compose.rememberNavController
import com.example.assignment2.data.BarItems

@Composable
fun BottomNavigationBar(){
    val navController = rememberNavController()
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
                        selected = selectedIndex == index,
                        onClick = {
                            selectedIndex = index
                        },
                        icon = {

                            Icon(
//                                painter = painterResource(navBarItem.icon),
                                imageVector = navBarItem.icon,
                                contentDescription = "Icon"
                            )
                        },

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