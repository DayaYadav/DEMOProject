package com.example.demo.utilClass

sealed class Screen(val route: String) {
    object SplashScreen : Screen(ScreenName.SPLASH.name)
    object LoginScreen : Screen(ScreenName.LOGIN.name)
    object DetailsScreen : Screen(ScreenName.DETAILS.name)
    object PlantScreen : Screen(ScreenName.PLANT.name)

}

enum class ScreenName {
    SPLASH,
    LOGIN,
    DETAILS,
    PLANT
}