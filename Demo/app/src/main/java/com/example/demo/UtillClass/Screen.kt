package com.example.demo.UtillClass

sealed class Screen (val route: String){

   object LoginScreen: Screen(ScreenName.LOGIN.name)
    object DetailsScreen: Screen(ScreenName.DETAILS.name)
    object PlantScreen: Screen(ScreenName.PLANT.name)

}

enum class ScreenName {
    LOGIN,
    DETAILS,
    PLANT
}