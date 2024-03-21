package com.example.heroapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.heroapp.util.Constants.DETAILS_SCREEN_ARGS


@Composable
fun SetupNavHost(navController: NavHostController){

    NavHost(navController = navController,  startDestination = Screen.Splash.route){
        composable(Screen.Splash.route){

        }
        composable(Screen.Welcome.route){

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