package com.example.bottombarjetpackcompose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.bottombarjetpackcompose.pages.HomePage
import com.example.bottombarjetpackcompose.pages.ProfilePage
import com.example.bottombarjetpackcompose.pages.SettingPage

@Composable
fun MainPage(modifier: Modifier = Modifier) {
    val navItem = listOf(
        NavItem(Icons.Default.Home ,"Home"),
        NavItem(Icons.Default.Person, "Profile"),
        NavItem(Icons.Default.Settings, "Settings"),
    )
    var selectedIndexBottomNav by remember {
        mutableStateOf(0)
    }


    Scaffold(modifier = modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {
                navItem.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndexBottomNav == index,
                        onClick = {
                            selectedIndexBottomNav = index
                        },
                        icon ={ Icon(imageVector = navItem.itemIcon, contentDescription ="" )},
                        label = { Text(text =navItem.itemName  )},
                        colors = NavigationBarItemDefaults.colors(Color.Red)

                    )
                }
            }
        }) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndexBottomNav)
    }


}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndexBottomNav: Int) {
    when (selectedIndexBottomNav) {
        0 -> HomePage()
        1 -> ProfilePage()
        2 -> SettingPage()
    }


}

data class NavItem(val itemIcon: ImageVector, val itemName: String)