package com.example.tmdbfilm

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.tmdbfilm.ui.theme.HomePage
import com.example.tmdbfilm.ui.theme.MainViewModel
import com.example.tmdbfilm.ui.theme.TMDBFILMTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import com.example.tmdbfilm.ui.theme.Screen
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.Person
import androidx.activity.viewModels




class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val navController = rememberNavController()

                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val windowClass = calculateWindowSizeClass(this)

            TMDBFILMTheme{
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.LightGray

                ){
                    val navController = rememberNavController()
                    Scaffold(
                        bottomBar = {
                            BottomNavigation(backgroundColor = Color.Blue) {

                                val navBackStackEntry by navController.currentBackStackEntryAsState()
                                val currentDestination = navBackStackEntry?.destination
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            Icons.Filled.Person,
                                            contentDescription = null
                                        )
                                    },
                                    label = { },
                                    selected = currentDestination?.hierarchy?.any { it.route == "profile" } == true,
                                    onClick = {
                                        navController.navigate("profile") {
                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true

                                            restoreState = true
                                        }
                                    }
                                )
                                BottomNavigationItem(
                                    icon = {

                                        Icon(
                                            painter = painterResource(R.drawable.photo1),
                                            contentDescription = null
                                        )
                                    },
                                    label = { },
                                    selected = currentDestination?.hierarchy?.any { it.route == "films" } == true,
                                    onClick = {
                                        navController.navigate("films") {

                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true

                                            restoreState = true
                                        }
                                    }
                                )

                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            painter = painterResource(R.drawable.photo1),
                                            contentDescription = null
                                        )
                                    },
                                    label = { },
                                    selected = currentDestination?.hierarchy?.any { it.route == "series" } == true,
                                    onClick = {
                                        navController.navigate("series") {

                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }
                                            launchSingleTop = true

                                            restoreState = true
                                        }
                                    }
                                )
                                BottomNavigationItem(
                                    icon = {
                                        Icon(
                                            Icons.Filled.People,
                                            contentDescription = null,

                                            )
                                    },
                                    label = { },
                                    selected = currentDestination?.hierarchy?.any { it.route == "Actors" } == true,
                                    onClick = {
                                        navController.navigate("Actors") {

                                            popUpTo(navController.graph.findStartDestination().id) {
                                                saveState = true
                                            }

                                            launchSingleTop = true

                                            restoreState = true
                                        }
                                    }
                                )
                            }
                        }) { innerpadding ->
                        NavHost(
                            navController = navController,
                            modifier = Modifier.padding(innerpadding),
                            startDestination = "profile"
                        ) {
                            composable("profile") {

                                HomePage(
                                    windowClass = windowClass,
                                    navController = navController)
                            }
                            composable("films") {

                                Screen(
                                    windowClass = windowClass,
                                    mainViewModel = MainViewModel(),
                                    navController = navController

                                )


                            }

                            /*composable("Actors") {

                                ScreenProfil(
                                    windowClass = windowClass,
                                    mainViewModel = MainViewModel()
                                )


                            }
                            composable("Series") {
                                ScreenSerie(
                                    windowClass = windowClass,
                                    mainViewModel = MainViewModel(),
                                    navController
                                )
                            }
                            composable("movie/{id}") {
                                DetailsScreen(
                                    it.arguments?.getString("id") ?: "",
                                    viewModel,
                                    navController
                                )
                            }
                            composable("serie/{id}") {
                                DetailsScreenSerie(
                                    it.arguments?.getString("id") ?: "",
                                    viewModel,
                                    navController
                                )
                            }

                             */

                            }
                                    }
                                    }
                        }



                        }

                    }
                }




