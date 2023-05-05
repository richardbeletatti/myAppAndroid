package com.richardbeletatti.beletatti

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.richardbeletatti.beletatti.screens.*
import com.richardbeletatti.beletatti.utils.NavItem

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // CREATED VARIABLES WHAT REPRESENT THE SCREENS
        val loginScreen = LoginScreen()
        val mainScreen = MainScreen()
        val profileScreen = ProfileScreen()
        val settingsScreen = SettingsScreen()
        val historicScreen = HistoricScreen()

        setContent {
            val navController = rememberNavController()

            NavHost(navController, startDestination = "loginScreen") {
                composable("loginScreen") { loginScreen.loginScreen(navController) }
                composable("mainScreen") { mainScreen.mainScreen(navController) }
                composable("historicScreen") { historicScreen.historicScreen(navController) }
                composable("profileScreen") { profileScreen.profileScreen(navController) }
                composable("settingsScreen") { settingsScreen.settingsScreen(navController) }
            }

            val navItems = listOf(
                NavItem("Início", Icons.Filled.Home, "mainScreen"),
                NavItem("Histórico", Icons.Filled.Search, "historicScreen"),
                NavItem("Perfil", Icons.Filled.Person, "profileScreen"),
                NavItem("Config.", Icons.Filled.Settings, "settingsScreen")
            )

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            if (currentRoute != "loginScreen") {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    BottomNavigation(
                        backgroundColor = Color.Blue
                    ) {
                        navItems.forEach { item ->
                            BottomNavigationItem(
                                icon = {
                                    Icon(
                                        item.icon,
                                        contentDescription = item.title,
                                        tint = Color.White
                                    )
                                },
                                label = { Text(item.title, color = Color.White) },
                                selected = currentRoute == item.route,
                                onClick = {
                                    navController.navigate(item.route) {
                                        launchSingleTop = true
                                        restoreState = true
                                    }
                                },
                                alwaysShowLabel = false,
                                modifier = if (currentRoute == "loginScreen") Modifier
                                    .height(0.dp)
                                    .background(color = Color.Transparent) else Modifier
                            )
                        }
                    }
                }
            }
        }
    }
}