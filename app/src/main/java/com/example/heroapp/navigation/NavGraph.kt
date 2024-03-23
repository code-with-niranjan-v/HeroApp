package com.example.heroapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.heroapp.presentation.screen.splash.SplashScreen
import com.example.heroapp.presentation.screen.welcome.WelcomeScreen
import com.example.heroapp.util.Constants.DETAILS_SCREEN_ARGS


@Composable
fun SetupNavHost(navController: NavHostController){

    NavHost(navController = navController,  startDestination = Screen.Welcome.route){
        composable(Screen.Splash.route){
            SplashScreen(navHostController = navController)
        }
        composable(Screen.Welcome.route){
            WelcomeScreen(navHostController = navController)
        }
        composable(Screen.Home.route){

        }
        composable(Screen.Details.route, arguments = listOf(navArgument(DETAILS_SCREEN_ARGS){
            type = NavType.IntType
        })){

        }
        composable(Screen.Search.route){

        }

    }

}