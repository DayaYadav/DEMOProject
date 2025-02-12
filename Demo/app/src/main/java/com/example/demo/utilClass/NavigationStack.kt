package com.example.demo.utilClass

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo.view.AllPlantsScreen
import com.example.demo.view.LoginScreen
import com.example.demo.view.UserDetailScreen
import com.example.demo.ViewModelClass.HomeViewModel
import com.example.demo.view.SplashScreen

/**
 * File to declare all screens with there expected arguments
 * Date:14-01-2025
 */
@Composable
fun NavigationStack(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.SplashScreen.route)
    {
        composable(route = Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.DetailsScreen.route + "?text={text}") {
            UserDetailScreen(text = it.arguments?.getString("text"), viewModel, navController)
        }
        composable(route = Screen.PlantScreen.route) {
            AllPlantsScreen()
        }
    }
}